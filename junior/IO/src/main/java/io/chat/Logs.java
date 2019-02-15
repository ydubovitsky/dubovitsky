package io.chat;

public interface Logs {
    /**
     * Метод получает строку и сохраняет ее в файл
     * @return
     */
    void save(String str);

    /**
     * Возвращает случайную фразу из файла
     * @return
     */
    String returnRandomString();
}
