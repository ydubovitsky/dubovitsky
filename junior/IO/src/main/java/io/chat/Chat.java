package io.chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * Интерфейс чата.
 */
public interface Chat {

    /**
     * Получаем поток ввода символов
     * @return - поток вывода
     */
    //void receiveMsg();

    /**
     * Выводит сообщения на консоль
     */
    void showMsg();
}
