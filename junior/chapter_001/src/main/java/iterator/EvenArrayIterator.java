package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    public boolean hasNext() throws NoSuchElementException {
        boolean value = false;
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
        while(!hasNext()) {
            result = (Object) array[currentPosition];
        }
        return result;
    }
}
