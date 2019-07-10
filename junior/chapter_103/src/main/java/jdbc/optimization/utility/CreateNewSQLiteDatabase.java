package jdbc.optimization.utility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * From http://www.sqlitetutorial.net/sqlite-java/create-database/
 * @author sqlitetutorial.net
 */
public class CreateNewSQLiteDatabase {

    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {
        // creates new database into resources folder
        String url = "jdbc:sqlite:C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\chapter_103\\src\\main\\resources\\optimization\\" + fileName;

        // When you connect to a non-existent SQLite database, SQLite automatically creates a new database.
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("test.db");
    }
}
