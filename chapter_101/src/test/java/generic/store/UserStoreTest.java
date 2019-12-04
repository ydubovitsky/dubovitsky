package generic.store;

import org.junit.Before;
import org.junit.Test;

/**
 * Класс для тестирования класса UserStore.
 */
public class UserStoreTest {

    User user;

    /**
     * Инициализация
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        user = new User("1");
    }

    /**
     * Добавляем нового пользователя в UserStore.
     */
    @Test
    public void initializationTest() {
        UserStore users = new UserStore(5);
        users.add(user);
        users.add(new User("1"));
    }

}