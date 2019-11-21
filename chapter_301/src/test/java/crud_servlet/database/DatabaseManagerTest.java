package crud_servlet.database;

import crud_servlet.beans.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

//TODO Откуда?
// Exception in thread "main" java.lang.NoClassDefFoundError: org/junit/platform/launcher/TestExecutionListener
class DatabaseManagerTest {

    DatabaseManager databaseManager;

    @BeforeAll
    public void init() {
        this.databaseManager = new DatabaseManager(new ConnectionDataBase());
    }

    @Test
    void getAllUsers() {
        Assertions.assertNotNull(databaseManager.getAllUsers());
        List<User> list = databaseManager.getAllUsers();
        for (User u : list) {
            System.out.println(u.getName());
        }
    }

    @Test
    void addUser() {
        databaseManager.addUser("Mordekay", "morda123", "efef23", "dr_mo@mail.ru");
    }

}