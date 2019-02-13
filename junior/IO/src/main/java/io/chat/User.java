package io.chat;

import java.io.InputStream;

/**
 * Интерфейс пользователя
 */
public interface User {
    /**
     * Посылает сообщение в чат.
     */
    InputStream sendMsg();
}
