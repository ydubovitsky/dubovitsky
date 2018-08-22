package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    /**
     * Множество отсортированных пользователей.
     */
    Set<User> usersSet = new TreeSet<>(users);
    /**
     * Метод заполняет лист пользователями.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        for (int i = 10; i > 0; i--) {
            users.add(new User("Иван", i));
        }
    }

    /**
     * Тест показывает сортирует ли метод SortUser
     */
    @Test
    public void whenUserSortedByAge() {
        SortUser sortUser = new SortUser();
        Set resultSet = sortUser.sort(users);
        Set<User> usersSet = new TreeSet<>(users);
        assertThat(usersSet, is(resultSet));
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