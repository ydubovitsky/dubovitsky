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
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        int key = -1;
        do {
            try {
                key = Integer.valueOf(ask(question));
                if (key > range.length || key < 0) {
                    throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                } else {
                    break;
                }
            } catch (MenuOutException exp) {
                System.out.println(exp.getMessage());
            } catch (NumberFormatException exp) {
                System.out.println("Необходимо ввести корректное значение");
            }
        } while(true);
        return key;
    }
}
