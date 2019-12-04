package io.chat;

import java.io.Reader;

/**
 * Интерфейс пользователя
 */
public interface User {
    /**
     * Создает поток ввода симвоов.
     */
    Reader sendMsg();
}
