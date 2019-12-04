package io.service;

import java.io.*;

/**
 * Сервис проверяет вводимые пользователем данные.
 */
public class Service {

    /**
     * метод должен проверить. что в байтовом потоке записано четное число.
     * @param in - входной поток байтов.
     * @return
     */
    boolean isNumber(InputStream in) {
        boolean result = false;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) { // try с ресурсом
            do {
                int value = Integer.parseInt(br.readLine());
                result = (value % 2) == 0;
            } while (br.ready()); // Пока есть что считывать
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


