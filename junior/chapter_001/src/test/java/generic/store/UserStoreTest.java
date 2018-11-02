package generic.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс для тестирования класса UserStore.
 */
public class UserStoreTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("1");
    }

    @Test
    public void initializationTest() {
        UserStore users = new UserStore(5);
        users.add(user);
    }

}