package io.chat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

/**
 * Конкретный класс, чат-Бот.
 */
public class ChatBot implements Bot {

    File logs;

    public ChatBot(File file) {
        this.logs = file;
    }

    @Override
    public String returnRandomString() {
        String result = new String();
        try {
            // Получаем список всех строк
            List<String> list = Files.readAllLines(this.logs.toPath());

            // Получить случайное значение строки
            Random random = new Random();
            int value = random.nextInt(list.size());

            // Вернуть случайную строку из файла
            result = list.get(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
