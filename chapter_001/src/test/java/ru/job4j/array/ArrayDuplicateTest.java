package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Класс для тестировки.
 */
public class ArrayDuplicateTest {

    ArrayDuplicate arrayDuplicate;

    @Before
    public void setUp() throws Exception {
        arrayDuplicate = new ArrayDuplicate();
    }

    @Test
    public void removeAllDuplicateFromArray() throws Exception {
        String[] expected = {"1", "2", "3", "4", "5"};
        String[] array = {"1", "1", "1", "2", "3", "4", "5"};
        Assertions.assertArrayEquals(expected, arrayDuplicate.remove(array));
    }

}