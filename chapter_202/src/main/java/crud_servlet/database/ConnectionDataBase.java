package crud_servlet.database;

import crud_servlet.intarfaces.Connectable;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class set connection to a database;
 */
public class ConnectionDataBase implements Connectable {
    //TODO do refactor!
    private static final String path = "C:\\Users\\user\\IdeaProjects\\dubovitsky\\chapter_301\\web\\WEB-INF\\resources\\database_prop.properties";
    private Connection connection;

    /**
     * Get connection to a database
     * @return
     */
    private Connection getConnection(Properties properties) {
        try {
            Class.forName(properties.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
        } catch (SQLException | ClassNotFoundException f) {
            f.printStackTrace();
        }
        return connection;
    }

    /**
     * Gets settings of database.
     * @param path
     * @return
     */
    private Properties getProperties(String path) {
        Properties properties = new Properties();
        try {
            FileReader reader = new FileReader(path);
            properties.load(reader);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return properties;
    }

    // TODO Нужно поправить это
    public final Connection getConnection() {
        return getConnection(getProperties(path));
    }
}
