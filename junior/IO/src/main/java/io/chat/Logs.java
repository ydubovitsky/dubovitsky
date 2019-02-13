package io.chat;

import java.io.InputStream;

public interface Logs {
    /**
     * Метод получает входной поток данных и сохраняет их в файл
     * @return
     */
    void save(InputStream inputStream);

    /**
     * Возвращает случайную фразу из файла
     * @return
     */
    String read();
}
