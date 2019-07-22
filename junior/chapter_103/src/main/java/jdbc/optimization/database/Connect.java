package jdbc.optimization.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class provide connect with database.
 */
public class Connect {

    /**
     * Connection
     */
    private Connection conn;

    /**
     * Connect to the database
     * @return
     */
    public Connection connection() {
        Connection conn = null;
        try {
            // db parameters
            InputStream input = this.getClass().getResourceAsStream("/jdbc/optimization/properties/app.properties");
            Properties properties = new Properties();
            properties.load(input);
            String url = properties.getProperty("url");
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

