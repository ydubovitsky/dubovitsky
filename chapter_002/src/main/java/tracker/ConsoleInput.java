package tracker;

import java.util.Scanner;

/**
 * Класс, отвечающий за ввод данных с клавиатуры.
 */
public class ConsoleInput implements Input {

    /**
     *
     */
    Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param question
     * @return
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     *
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        int result = Integer.valueOf(this.ask(question));
        boolean isExist = false;
        for (int value : range) {
            if (result == value) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
        }
        return result;
    }
}

