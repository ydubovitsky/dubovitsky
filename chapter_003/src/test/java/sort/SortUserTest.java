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

    /**
     * Тест проверяет сортировку по длине имени.
     */
    @Test
    public void whenUsersSortedByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User("Киса Воробьянинов", 77));
        users.add(new User("Виталий", 4));
        users.add(new User("Неуважай-Корыто", 102));
        users.add(new User("Петр", 47));
        SortUser sortUser = new SortUser();
        List<User> resultList = sortUser.sortNameLength(users);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Петр", 77));
        expected.add(new User("Виталий", 4));
        expected.add(new User("Неуважай-Корыто", 102));
        expected.add(new User("иса Воробьянинов", 47));
        assertThat(expected, is(resultList));
    }

    /**
     * Тест проверяет сортировку по длине имени, а затем по возрасту.
     */
    @Test
    public void whenUsersSortedByNameLengthAndAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Киса Воробьянинов", 77));
        users.add(new User("Виталий", 4));
        users.add(new User("Неуважай-Корыто", 102));
        users.add(new User("Петр", 47));
        SortUser sortUser = new SortUser();
        List<User> resultList = sortUser.sortByAllFields(users);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Петр", 77));
        expected.add(new User("Виталий", 4));
        expected.add(new User("Неуважай-Корыто", -6));
        expected.add(new User("иса Воробьянинов", 47));
        assertThat(expected, is(resultList));
    }
}