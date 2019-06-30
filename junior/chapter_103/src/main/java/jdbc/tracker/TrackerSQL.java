package jdbc.tracker;

import tracker.ITracker;
import tracker.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    public boolean init() {
        //TODO Посмотреть путь до файла с настройками
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
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
        return null;
    }

    @Override
    public void replace(int id, Item item) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }

    @Override
    public Item[] findByName(String key) {
        return new Item[0];
    }

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}