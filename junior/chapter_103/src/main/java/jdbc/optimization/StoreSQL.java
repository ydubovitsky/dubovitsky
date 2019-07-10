package jdbc.optimization;

import jdbc.optimization.config.Config;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * https://habr.com/ru/sandbox/88039/
 * https://alekseygulynin.ru/rabota-s-sqlite-v-java/
 */
public class StoreSQL implements AutoCloseable {

    private final Config config;
    private Connection connect;
    public Statement statmt;
    public ResultSet resSet;
    // name of table
    private String table;

    public StoreSQL(Config config, String table) {
        this.table = table;
        this.config = config;
    }

    /**
     * Connect to a sample database
     */
    public void connection() throws ClassNotFoundException, SQLException    {
        connect = null;
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection(config.get("url"));

        System.out.println("База Подключена!");
        // TODO Как работает этот кусок?
        if(connect == null) {
            DatabaseMetaData meta = connect.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
        }
    }

    /**
     * Create a table
     */
    public void CreateTable() throws SQLException    {
        statmt = connect.createStatement();
        // Если таблица отсутствует, то создает ее.
        statmt.execute(
                "CREATE TABLE if not exists " + table + " ('field' INTEGER);"
        );
        System.out.println("Таблица создана или уже существует.");
    }

    /**
     * Output a table
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void ReadDB() throws  SQLException    {
        resSet = statmt.executeQuery("SELECT * FROM " +  table + ";");

        while(resSet.next()) {
            int field = resSet.getInt("field");
            System.out.println( "field = " + field );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    /**
     * метод generate(int size) - генерирует в базе данных n записей.
     * @param size
     */
    public void generate(int size) throws SQLException {
        resSet = statmt.executeQuery("SELECT COUNT(*) as 'count' from " + table + ";");
        int value = resSet.getInt("count");

        // if row in the table > 0 then add new rows and delete old rows.
        if (value > 0) {
            statmt.execute("delete from " + table + ";");
            for (int i = 0; i < size; i++) {
                statmt.execute("insert into " + table + " values (" + i + ");");
            }
        }
    }

    /**
     * Return empty list. //TODO Зачем?
     * @return
     */
    public List<Map.Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config, "entry");
        storeSQL.connection();
        storeSQL.CreateTable();
        storeSQL.generate(10);
        storeSQL.ReadDB();
    }
}
