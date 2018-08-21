package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс-Тест.
 */
public class SortUserTest {
    /**
     * Лист пользователей
     */
    List<User> users = new ArrayList<User>();
    User user1 = new User("Петр", 99);
    User user2 = new User("Иван", 9);
    User user3 = new User("Федор", -5);
    User user4 = new User("Киса", 15);
    User user5 = new User("Ося", 0);

    /**
     * Метод заполняет лист пользователями.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    /**
     * Тест показывает сортирует ли метод SortUser.
     * Приходится конвертировать множество в Лист, чтобы прошел тест.
     */
    @Test
    public void whenUserSortedByAge() {
        List<User> result = new ArrayList(new SortUser().sort(users));
        List<User> expected = new ArrayList<>();
        expected.add(user3);
        expected.add(user5);
        expected.add(user2);
        expected.add(user4);
        expected.add(user1);
        assertThat(result, is(expected));
    }
}