//package io.service;
//
//import org.junit.jupiter.api.Assertions;
//
//import java.io.*;
//
///**
// * Класс, отвечающий за тестирование Service;
// */
//class ServiceTest {
//
//    Service service;
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//        service = new Service();
//    }
//
//    @org.junit.jupiter.api.Test
//    void isNumber() {
//        Assertions.assertEquals(false,service.isNumber(new ByteArrayInputStream("5".getBytes())));
//    }
//}
