package io.chat;

import java.io.Reader;

/**
 * Интерфейс Бота.
 */
public interface Bot {
    /**
     * Получает Поток ввода из файла(т.е. случайную фразу)
     * @return
     */
    Reader receiveMsg(Reader msg);
}
