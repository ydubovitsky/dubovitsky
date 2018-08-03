package tracker;

/**
 * Интерфейс отвечающий за ввод значений.
 */
public interface Input {

    /**
     * Возвращает строковое значение введное пользователем.
     * @param question
     * @return
     */
    String ask(String question);

    /**
     * Возвращает int значение введеное пользователем.
     * @param question
     * @param range
     * @return
     */
    int ask(String question, int range);
}