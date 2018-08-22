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
    User user1 = new User("Петр Великий Государь Московский и Всея Русси", 99);
    User user2 = new User("Ян", 9);
    User user3 = new User("Федор", -5);
    User user4 = new User("Киса Воробьянинов", 15);
    User user5 = new User("Ося Бедер", 0);

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
     * Тест показывает сортирует ли метод public Set<User> sort (List<User> list).
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

    /**
     * Тест показывает сортирует ли метод public List<User> sortNameLength (List<User> list).
     */
    @Test
    public void whenUsersSortedByNameLength() {
        List<User> result = new SortUser().sortNameLength(users);
        List<User> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user4);
        expected.add(user5);
        expected.add(user3);
        expected.add(user2);
//        for (User a : result) {
//            System.out.println(a.getName());
//        }
        assertThat(result, is(expected));
    }

    /**
     * Тест показывает сортирует ли метод public List<User> sortNameLength (List<User> list).
     */
    @Test
    public void whenUsersSortedByAgeAndName() {
        List<User> result = new SortUser().sortByAllFields(users);
        List<User> expected = new ArrayList<>();
        expected.add(user4);
        expected.add(user5);
        expected.add(user1);
        expected.add(user3);
        expected.add(user2);
        for (User a : result) {
            System.out.println(a.getName());
        }
        assertThat(result, is(expected));
    }
}