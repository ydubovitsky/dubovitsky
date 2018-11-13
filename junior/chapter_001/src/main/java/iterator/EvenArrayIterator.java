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
    public boolean hasNext() throws ArrayIndexOutOfBoundsException {
        boolean value = false;
        if (currentPosition > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (array[currentPosition] % 2 == 0) {
            value = true;
        }
        currentPosition++;
        return value;
    }

    /**
     * Возвращает следующий четный элемент из массива.
     * @return
     */
    @Override
    public Object next() {
        Object result = null;
        do {
            result = array[currentPosition];
        } while (!hasNext());
        return result;
    }
}
