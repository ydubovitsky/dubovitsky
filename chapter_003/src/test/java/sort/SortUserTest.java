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
}