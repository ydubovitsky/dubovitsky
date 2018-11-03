package generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

    /**
     * Количество элементов в массиве.
     */
    private int index;

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
        this.index = index;
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
     * Если данный индекс существует, то
     * Удаляет элемент по индексу из массива и сдвигает его на 1 позицию.
     * @param index - индекс элемента, который требуется удалить.
     */
    public void delete(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
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
                boolean value = false;
                int index = indexIterator;
                if (array[index++] != null) value = true;
                return value;
            }

            /**
             * Возвращает следующий элемент из списка.
             * @return
             */
            @Override
            public T next() {
                T value = null;
                if (array[indexIterator] == null) {
                    throw new ArrayIndexOutOfBoundsException("Вышли за предел массива.");
                }
                if (array.length > 1 && indexIterator > 0) {
                    value = array[indexIterator++];
                }
                if (indexIterator == 0){
                    value = array[0];
                    indexIterator++;
                }
                return value;
            }
        };
    }
}


