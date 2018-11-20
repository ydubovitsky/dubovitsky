package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс Динамический контейнер базируется на массиве (Object[] container).
 * При полном заполнении увеличивается.
 */
public class DynamicListBasedOnArray<E> implements Iterable<E> {

    /**
     * Количество добавленных элементов.
     */
    private int size = 0;

    /**
     * Хранилище элементов.
     */
    private Object[] container = new Object[7];

    /**
     * Счетчик модификаций коллекции.
     */
    private int modCount = 0;

    /**
     * Добавление элементов в контейнер. Контейнер расширяется при полном заполнении.
     * @param value
     */
    public void add(E value) {
        if (container.length > size) {
            container[size] = value;
            size++;
        }
        if (container.length == size) {
            Object[] temp = new Object[container.length + 15]; // Временный массив
            System.arraycopy(container, 0, temp, 0, size--);
            container = temp;
            container[size] = value;
            size++;
            modCount++;
        }
    }

    /**
     * Метод возвращает элемент из листа, если индекс существует
     * @param index
     * @return
     */
    public E get(int index) throws NoSuchMethodException {
        E result;
        if (0 <= index & index <= size) {
            result = (E) container[index];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }



    /**
     * Итератор реализует fail-fast поведение, т.е. если с момента создания итератора
     * коллекция подверглась структурному изменению,
     * итератор должен кидать ConcurrentModificationException.
     * @return
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            /**
             * Индекс для итератора.
             */
            private int indexIterator = 0;

            /**
             Счетчик изменений.
             */
            private int localeMode = modCount;

            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                if (localeMode != modCount) {
                    throw new ConcurrentModificationException();
                }
                return indexIterator < size;
            }

            @Override
            public Object next() throws NoSuchElementException {
                Object object;
                if (hasNext()) {
                    object = container[indexIterator];
                    indexIterator++;
                } else {
                    throw new NoSuchElementException();
                }
                return object;
            }
        };
    }
}

