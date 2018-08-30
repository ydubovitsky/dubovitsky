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
    public void whenInArrayOnlyTrueElements() {
        boolean expected = true;
        boolean[] data = new boolean[]{true, true, true};
        Assertions.assertEquals(expected, check.mono(data));
    }

    @Test
    public void whenInArrayHaveVariousElement() {
        boolean expected = false;
        boolean[] data = new boolean[]{true, false, true};
        Assertions.assertEquals(expected, check.mono(data));
    }

    @Test
    public void whenInArrayOnlyFalseElements() {
        boolean expected = true;
        boolean[] data = new boolean[]{false, false, false};
        Assertions.assertEquals(expected, check.mono(data));
    }
}