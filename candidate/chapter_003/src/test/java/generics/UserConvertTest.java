package generics;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для тестирования.
 */
public class UserConvertTest {

    /**
     * Создаем объект тестируемого класса.
     */
    UserConvert userConvert = new UserConvert();

    /**
     * Тест проверяет работу метода конвертации листа пользователей
     * в map<id, user>.
     */
    @Test
    public void whenListConvertToMap() {
        User user1 = new User(1, "Петр", "Арсентьевград");
        User user2 = new User(2,  "Andrei Hincu", "Город программистов");
        Map<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        Map<Integer, User> result = userConvert.process(Arrays.asList(user1,
                user2));
        assertThat(result, is(expected));
    }
}