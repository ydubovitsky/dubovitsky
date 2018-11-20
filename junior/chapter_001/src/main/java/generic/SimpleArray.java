package generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    /**
     * Ссылка на массив обобщенных элементов.
     */
    private T[] array;

    /**
     * Текущий индекс. Инициализирован по умолчанию.
     */
    private int currentIndex = 0;

    /**
     * Конструктор, принимающий количество элементов массива.
     * @param index
     */
    public SimpleArray(int index) {
        array = (T[]) new Object[index];
    }

    /**
     * Добавляет обобщенный элемент в массив и увеличивает индекс массива.
     * @param model - объект для добавления.
     */
    public void add(T model) {
        array[currentIndex++] = model;
    }

    /**
     * Устанавливает новое значение элемента массива по индексом index.
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        if (index > this.array.length) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса не существует");
        } else {
            array[index] = model;
        }
    }

    /**
     * Если данный индекс существует, то массив сдвигается на 1 позицию, последнему элементу массива
     * присваивается null.
     * @param index - индекс элемента, который требуется удалить.
     */
    public void delete(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[array.length - 1] = null;
    }

    /**
     * Возвращает элемент из массива.
     * @param index
     * @return
     */
    public T get(int index) {
        T value = null;
        if (index > this.array.length) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса не существует");
        } else {
            value = array[index];
        }
        return value;
    }

    /**
     * Собственный итератор для обобщенного массива.
     * @return - итератор.
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            /**
             * Индекс для итератора по умолчанию.
             */
            private int indexIterator = 0;

            /**
             * Проверяет есть ли следующий элемент в списке.
             * @return
             */
            @Override
            public boolean hasNext() {
                return indexIterator < currentIndex; // меньше ли текущая позиция общего количества элементов в массиве
            }

            /**
             * Возвращает следующий элемент из списка.
             * @return
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[indexIterator++]; //просто сдвигаем
            }
        };
    }
}


