package io.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Конкретный класс пользователя
 */
public class UserOne implements User {

    @Override
    public Reader sendMsg() {

        // Создаеем буфферизированный поток ввода с консоли
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }
}
