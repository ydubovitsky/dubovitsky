package io;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс, отвечающий за тестирование Service;
 */
class ServiceTest {

    Service service;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        service = new Service();
    }

    @org.junit.jupiter.api.Test
    void isNumber() {
        Assertions.assertEquals(false,service.isNumber(new ByteArrayInputStream("5".getBytes())));
    }

    @org.junit.jupiter.api.Test
    void dropAbuses() {
        IntFunction<String[]> intFunction = (int n) -> {
            String[] strings = new String[1];
            strings[n] = "плохо";
            return strings;
        };
        System.out.println(intFunction.apply(0)[0]);
    }
}