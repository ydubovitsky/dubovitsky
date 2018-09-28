package tracker;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Класс, отвечающий за ввод данных с клавиатуры.
 */
public class ConsoleInput {

    /**
     * Отвечает за считывание вопросов с консоли.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Функция выводит вопрос на консоль.
     * @param question - вопрос с консоли
     * @return
     */
    public String ask(String question) {
        Consumer consumer = n -> {
            System.out.println(n);
        };
        consumer.accept(question);
        return scanner.nextLine();
    }

    /**
     * Функция отвечает за вывод меню в диапазоне значений range.
     * Используется лямбда-выражение и Встроенный функциональный интерфейс.
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        BiFunction<String, int[], Integer> biConsumer = (a, b) -> {
            int key = -1;
            do {
                try {
                    key = Integer.valueOf(ask(question));
                    if (key > range.length || key < 0) {
                        throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                    } else {
                        break;
                    }
                } catch (MenuOutException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            return key;
        };
        return biConsumer.apply(question, range);
    }
}

