package ru.job4j.array;

import org.junit.Test;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;

/**
 * Класс для тестирования Check.java.
 */
public class CheckTest {

    /**
     * Ссылка на переменную экземпляра.
     */
    Check check;

    /**
     * Создаем объект класса Check и помещаем в переменную экземпляра.
     */
    @Before
    public void setUp() {
        check = new Check();
    }

    @Test
    public void whenInArrayHaveFalseElement() {
        boolean expected = false;
        boolean[] data = new boolean[]{true, true, false, true};
        Assertions.assertEquals(expected, check.mono(data));
    }

    @Test
    public void whenInArrayHaveTrueElement() {
        boolean expected = true;
        boolean[] data = new boolean[]{true, true, true, true};
        Assertions.assertEquals(expected, check.mono(data));
    }
}