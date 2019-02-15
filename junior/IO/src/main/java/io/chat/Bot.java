package io.chat;

/**
 * Интерфейс Бота.
 */
public interface Bot {
    /**
     * Получает Поток ввода из файла(т.е. случайную фразу)
     * @return
     */
    String returnRandomString();
}
