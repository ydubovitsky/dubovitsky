package iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class JaggedArrayIterator implements Iterator {

    /**
     * Массив для обработки.
     */
    private Integer[][] doubleArray;

    /**
     * Задано начальное положение текущего элемента в массиве,
     * изменяется в процессе работы программы.
     */
    private int x = 0;
    private int y = 0;

    /**
     * Конструктор класса.
     * @param array
     */
    public JaggedArrayIterator(Integer[][] array) {
        doubleArray = array;
    }

    /**
     * Перебираем двумерный массив; Работаем с первым вложенным массивом,
     * перебираем его, если есть следующий элемент в это массиве возвращаем true,
     * если нет - переходим к следующему массиву.
     * @return - true если следующий элемент существует.
     */
    @Override
    public boolean hasNext() {
        boolean exist = false;
        // Проверка переполнения
        if (x == doubleArray.length - 1 && y == doubleArray[doubleArray.length - 1].length - 1) {
            return false;
        }
        // Выбираем первый вложенный массив
        for (int i = 0; i < doubleArray.length - 1; i++) {
            // Перебираем первый массив
            for (int j = 0; j < doubleArray[this.x].length - 1; j++) {
                if (doubleArray[this.x].length - 1 > y && doubleArray[this.x][this.y++] != null) {
                    exist = true;
                    System.out.println("Я существую " + doubleArray[x][y]);
                    return exist;
                    // Если достигнут конец текущего массива переходим к следующему
                    // и проверяем его первый элемент.
                } else {
                    this.x++;
                    this.y = 0;
                    if (doubleArray[x][y] != null) {
                        exist = true;
                        System.out.println("Я существую " + doubleArray[x][y]);
                        return exist;
                    }
                }
            }
        }
        return exist;
    }

    /**
     * Возвращает следующий элемент в массиве.
     * @return - элемент массива.
     */
    @Override
    public Object next() {
        Object value = null;
        if (this.hasNext()) {
            value = this.doubleArray[x][y];
        }
        return value;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer consumer) {

    }

    public static void main(String[] args) {
        JaggedArrayIterator jaggedArrayIterator = new JaggedArrayIterator(new Integer[][]{{1,2,3,4,5,6},{1111,-5,3,-7,-1904},{0,0,0}});
//        for (int i = 0; i < 25; i++) {
//            System.out.println(jaggedArrayIterator.hasNext());
//        }
        System.out.println(jaggedArrayIterator.next());
        System.out.println(jaggedArrayIterator.next());
    }
}