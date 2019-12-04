package lambda.functional;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Класс, выполняющий математическую операцию, определяемую в функциональном интерфейсе.
 */
public class Multiple {

    /**
     *
     * @param a
     * @param b
     * @param value
     * @param operation - Первый функциональный интерфейс.
     * @param media - Второй функциональный интерфейс.
     */
    public void multiple(int a, int b, int value, BiFunction<Integer, Integer, Double> operation, Consumer<Double> media) {
        for (int i = a; i < b; i++) {
            media.accept(operation.apply(value, i));
        }
    }

    /**
     * Главный метод.
     * В качестве параметра передается анонимный класс.
     * @param args
     */
    public static void main(String[] args) {
        Multiple multiple = new Multiple();
//        Функция реализована при помощи анонимного класса.
//        multiple.multiple(0, 20, 157, new Operation() {
//            @Override
//            public double calc(int left, int right) {
//                return left * right;
//            }
//        });
//        Лямбда-выражение.
        multiple.multiple(0, 20, 157,
                (value, index) -> {
                    double result = value * index;
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
