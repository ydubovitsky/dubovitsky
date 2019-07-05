package jdbc.optimization;

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

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Connect to a sample database
     */
    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public void connection() throws ClassNotFoundException, SQLException
    {
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

    // --------Создание таблицы--------
    public void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = connect.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    /**
     *  метод generate(int size) - генерирует в базе данных n записей.
     * @param size
     */
    public void generate(int size) {

    }

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
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.connection();
        storeSQL.CreateDB();
        storeSQL.WriteDB();
        storeSQL.ReadDB();
    }
}
