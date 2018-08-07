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
        boolean find = true;
        int key = -1;
        int i = 0;
        do {
            try {
                key = Integer.valueOf(ask(question));
                do {
                    if (key == range[i]) {
                        find = false;
                        break;
                    } else {
                        if (i == range.length - 1) {
                            throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                        }
                    }
                    i++;
                } while (true);
            } catch (MenuOutException exp) {
                System.out.println(exp.getMessage());
            } catch (NumberFormatException exp) {
                System.out.println("Необходимо ввести корректное значение");
            }
        } while(find);
        return key;
    }
}
