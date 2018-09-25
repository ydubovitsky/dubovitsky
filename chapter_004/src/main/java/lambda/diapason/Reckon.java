package lambda.diapason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 1. Реализовать метод подсчета функции в диапазоне.

 List<Double> diapason(int start, int end, Function<Double, Double> func);

 2. Реализации функций.
 - линейная.
 - квадратичная.
 - логарифмическая.

 3. Необходимо использовать только встроенные функциональные интерфейсы

 */
public class Reckon {

    /**
     * Список значений функции.
     */
    ArrayList<Double> list = new ArrayList<>();

    /**
     * Метод подсчета функции в диапазоне start - end.
     * @param start
     * @param end
     * @param func
     * @return
     */
    List<Double> diapason(double start, double end, BiFunction<Double, Double, Double> func) {
        for (double i = start; i < end; i++) {
            list.add(func.apply(start, end));
        }
        return list;
    }

    /**
     * Графиком линейной функции y=kx+m является прямая.
     * @param x – независимая переменная.
     * @param m - некоторое число.
     * @return
     */
    BiFunction<Double, Double, Double> linear = (x, m) -> m * x + m;

    /**
     * Квадратичной функция вида y=ax2+bx+c, где a,b,c - числа, причем a≠0.
     * @param x – независимая переменная.
     * @param m - некоторое число.
     * @return
     */
    BiFunction<Double, Double, Double> square = (x, m) -> {
        return m != 0 ? (m * Math.pow(x, 2) + m * x + m) : ((m + 1) * Math.pow(x, 2) + m * x + m);
    };
    
    /**
     * Функцию, заданную формулой y=logax, называют логарифмической функцией с основанием a.
     (a>0,a≠1)
     * @param x – независимая переменная.
     * @param m - некоторое число.
     * @throws Exception - если (a>0,a≠1).
     * @return
     */
    BiFunction<Double, Double, Double> logarithm = (x, m) -> {
        double result = 0;
        if (m > 0 & m != 1) {
            result = Math.log(x) / Math.log(m);
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    };
}
