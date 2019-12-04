package lambda.methods;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MathUtils {

    /**
     * @param start
     * @param finish
     * @param value
     * @param op - Предопределенный функциональный интерфейс.
     * @param media - Интерфейс, который принимает один входной аргумент и не возвращает результат.
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    /**
     * Статическая функция сложения.
     * @param left
     * @param second
     * @return
     */
    public static double add(int left, int second) {
        return left + second;
    }

    /**
     * Статическая функция умножения.
     * @param left
     * @param second
     * @return
     */
    public static double div(int left, int second) {
        return left / second;
    }

    /**
     * Главный метод, использующий две лямбда-функции.
     * 1. Для Вызова статического метода.
     * 2. Для вывода результата.
     * @param args
     */
    public static void main(String[] args) {
        MathUtils mathUtils = new MathUtils();
        mathUtils.multiple(0, 10, 157,
                MathUtils::add,
                result -> System.out.println(result)
        );
    }
}
