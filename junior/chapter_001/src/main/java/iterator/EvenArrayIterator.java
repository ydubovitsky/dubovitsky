package iterator;

import java.util.Iterator;

/**
 *  Класс реализующий итератор, возвращающий только четные цифры.
 */
public class EvenArrayIterator implements Iterator {

    /**
     * Исходный массив.
     */
    private Integer[] array;

    /**
     * Текущая позиция индекса массива.
     */
    private int currentPosition = 0;

    /**
     * Конструктор.
     * @param array - входной массив.
     */
    public EvenArrayIterator(Integer[] array) {
        this.array = array;
    }

    /**
     * Возвращает true, только если в массиве есть четные после указателя.
     * @return
     */
    @Override
    public boolean hasNext() {
        boolean value = false;
        if (currentPosition > this.array.length) {
            return value;
        }
        if (array[currentPosition] % 2 == 0) {
            value = true;
            currentPosition++;
        } else {
            currentPosition++;
        }
        return value;
    }

    /**
     * Возвращает следующий четный элемент из массива.
     * @return
     */
    @Override
    public Object next() {
        Integer value = null;
        for (int i = currentPosition; i < array.length; i++) {
            if (array[currentPosition] % 2 == 0) {
                value = array[currentPosition++];
                break;
            } else {
                currentPosition++;
            }
        }
        return value;
    }
}
