package io.chat;

import java.io.Reader;

public interface Logs {
    /**
     * Метод получает входной поток данных и сохраняет их в файл
     * @return
     */
    void save(Reader reader);

    /**
     * Возвращает случайную фразу из файла
     * @return
     */
    String returnRandomString();
}
