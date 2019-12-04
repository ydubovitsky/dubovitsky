package jdbc.optimization.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * For example
 * https://habr.com/ru/sandbox/88039/
 */
public class StoreSQL {

    @Autowired
    @Qualifier("connection")
    private Connection connection;

    private Statement statmt;
    private ResultSet result;

    public StoreSQL(Connection connection) {
        this.connection = connection;
    }

    public StoreSQL() {
    }

    /**
     * Drop table
     * @throws SQLException
     */
    public void dropTable() throws SQLException {
        statmt = connection.createStatement();
        statmt.execute("drop table 'entry';");
    }

    /**
     * Create table
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        statmt = connection.createStatement();
        statmt.execute(
                "CREATE TABLE if not exists 'entry' ('field' INTEGER);"
        );
        System.out.println("Таблица создана или уже существует.");
    }

    /**
     * Output table
     * @throws SQLException
     */
    public void outputTable() throws SQLException {
        result = statmt.executeQuery("SELECT * FROM entry");

        while(result.next()) {
            int field = result.getInt("field");
            System.out.println( "field = " + field);
            System.out.println();
        }
        System.out.println("Таблица выведена");
    }

    /**
     * This method generate n rows into table 'entry'
     * @param size - count of fields
     * @throws SQLException
     */
    public void generate(int size) {
        try {
            // TODO Можно упростить и все в один запрос объединить
            int result = statmt.executeQuery("Select count(field) as amount from entry;")
                    .getInt("amount");
            // if table not empty
            if (result > 0) {
                statmt.execute("delete from entry");
            }
            connection.setAutoCommit(false);
            for (int i = 0; i < size; i++) {
                statmt.addBatch("INSERT INTO 'entry' ('field') VALUES (" + i + "); ");
            }
            statmt.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO Этот метод не должен тут находиться, он не относится к работе с БД
    /**
     * Return all rows from table
     * @throws SQLException
     */
    public List<Integer> load() throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        result = statmt.executeQuery("SELECT * FROM 'entry';");
        while(result.next()) {
            list.add(result.getInt("field"));
        }
        return list;
    }
}
