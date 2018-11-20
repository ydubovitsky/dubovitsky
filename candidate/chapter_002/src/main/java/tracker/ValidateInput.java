package tracker;

/**
 * Класс, отвечающий за валидацию вводимых данных.
 */
public class ValidateInput implements Input {

    /**
     * Интерфейс, отвечающий за ввод данных.
     */
    private final Input input;

    /**
     * Конструктор принимающий любой!!! объек, реализующий интерфейс Input;
     * @param input
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод вызывает метод ask() у объекта класса реализующего интерфейс Input
     * и переданный в качестве параметра в конструктор ValidateInput.
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Метод проверяет валидность вводимых пользователем данных.
     * Если ключ не соответствует значению из массива переданных ключей, возникает исключение.
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        boolean invalidNumber = true;
        int result = -1;
        do {
            try {
                result = this.input.ask(question, range);
                invalidNumber = false;
            } catch (MenuOutException moe) {
                System.out.println("Необходимо выбрать значение из диапазона меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо ввести корректное значение");
            }
        } while (invalidNumber);
        return result;
    }
}
