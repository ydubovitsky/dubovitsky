package io.chat;

import java.io.OutputStream;

/**
 * Интерфейс Бота.
 */
public interface Bot {
    /**
     * Получает сообщение от пользователя.
     * @return
     */
    void reciveMsg();

    /**
     * Отвечает на вопрос пользователя.
     * @return - возвращает поток вывода.
     */
    OutputStream sendAnswer();
}
