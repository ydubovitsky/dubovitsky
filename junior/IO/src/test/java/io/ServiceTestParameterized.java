package io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Параметризованные тесты
 */
@RunWith(Parameterized.class)
public class ServiceTestParameterized {

    private Service service;
    private InputStream testData;
    private boolean expected;

    /**
     * Конструктор
     * @param testData
     * @param expected
     */
    public ServiceTestParameterized(InputStream testData, boolean expected) {
        this.testData = testData;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        service = new Service();
    }

    @Test
    public void isNumber() {
        final boolean actual = service.isNumber(testData);
        assertEquals(expected, actual);
    }


    /**
     * Cтатический метод, возвращающий список данных, которые будут использованы в качестве аргументов конструктора класса
     * @return
     */
    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][] {
                { new ByteArrayInputStream("5".getBytes()), false },
                { new ByteArrayInputStream("4".getBytes()), true },
                { new ByteArrayInputStream("7".getBytes()), false },
                { new ByteArrayInputStream("10".getBytes()), true },
        });
    }
}