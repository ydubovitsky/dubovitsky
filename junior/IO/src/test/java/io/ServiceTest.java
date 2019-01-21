package io;

import org.junit.jupiter.api.Assertions;

import java.io.*;
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
        InputStream in = System.in;
        OutputStream out = System.out;
        try {
            in.read(new byte[]{'c', 'a', 'h'});
            service.dropAbuses(in, out, new String[]{"a"});
            ((PrintStream) out).println(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
