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
        int key = -1;
        do {
            try {
                key = Integer.valueOf(ask(question));
                if (key > range.length || key < 0) {
                    throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                }
                break;
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return key;
    }
}

