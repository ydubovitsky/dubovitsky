package jdbc.tracker;

import tracker.ConsoleInput;
import tracker.ITracker;
import tracker.Item;
import tracker.StartUI;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    /**
     * Two types of statement
     */
    private PreparedStatement preparedStatement;
    private Statement statement;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("tracker/app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public Item add(Item item) {
        try{
            preparedStatement = connection.prepareStatement(
                    "insert into item(name, description, time) values (?,?,?)"
            );
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDesc());
            preparedStatement.setTime(3, new Time(System.currentTimeMillis()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void replace(int id, Item item) {
        try{
            preparedStatement = connection.prepareStatement(
                    "update item set name = ?, description = ?, time = ? where item.id = " + id
            );
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDesc());
            preparedStatement.setTime(3, new Time(System.currentTimeMillis()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try{
            preparedStatement = connection.prepareStatement("delete from item where id = ?");
            // TODO for testing? where
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item[] findAll() {
        Item[] items = null;
        try{
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select * from item");

            // Getting count of rows in result set;
            ResultSetMetaData rsmd = set.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            items = new Item[columnsNumber];
            int i = 0;
            while (set.next()) {
                items[i] = new Item(
                        set.getString("name"),
                        set.getString("description"),
                        set.getTime("time").getTime(),
                        "no comments"
                );
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item[] findByName(String key) {
        Item[] item = null;
        try{
            preparedStatement = connection.prepareStatement("select * from item where name = ?");
            preparedStatement.setString(1, key);
            ResultSet set = preparedStatement.executeQuery();

            // Getting count of rows in result set;
            ResultSetMetaData rsmd = set.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            item = new Item[columnsNumber];
            int i = 0;
            while (set.next()) {
                item[i] = new Item(
                        set.getString("name"),
                        set.getString("description"),
                        set.getTime("time").getTime(),
                        "no comment"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try{
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery( "select * from item where id = " + id);
            while (set.next()) {
                item = new Item(
                        set.getString("name"),
                        set.getString("description"),
                        set.getTime("time").getTime(),
                        "no comment"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {

    }

    public static void main(String[] args) {
        TrackerSQL trackerSQL = new TrackerSQL();
        trackerSQL.init();
        StartUI startUI = new StartUI(new ConsoleInput(), trackerSQL);
        startUI.init();
    }
}