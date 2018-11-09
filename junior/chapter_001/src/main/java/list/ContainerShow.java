package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер базируется на связанном списке(Node<E> node).
 * Реализуе интерфей Iterator.
 * Размеры контейнера увеличиваются по мере добавления элементов.
 */
public class ContainerShow<E> implements Iterable<E> {

    /**
     * Последний добавленыый элемент.
     */
    private Container<E> lastElement;

    /**
     * Количество добавленных элементов.
     */
    private int size = 0;

    /**
     * Количество изменений.
     */
    private int modifications = 0;

    /**
     * Добавляем элемент в связный список.
     * @param value
     */
    public void add(E value) {
        Container<E> container = new Container<>(value);
        container.previous = this.lastElement; // Связываем добавляемый элемент с последним добавленным элементом.
        this.lastElement = container;
        size++;
        modifications++;
    }

    /**
     * Извлекаем элемент из связного списка.
     * @param index
     * @return
     */
    public E get(int index) {
        if (index > this.size) {
            throw new NoSuchElementException();
        }
        Container<E> temp = lastElement;
        for (int i = size - 1; i != index; i--) {
            temp = temp.previous;
        }
        return temp.value;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            /**
             * Текущий индекс перебора итератора.
             */
            int iteratorSize = 0;

            /**
             * Локальный подификатор, нужен для отслеживания изменений в основном классе.
             */
            int localModification = modifications;

            @Override
            public boolean hasNext() throws ConcurrentModificationException{
                if (localModification != modifications) {
                    throw new ConcurrentModificationException();
                }
                return iteratorSize < size;
            }

            @Override
            public E next() throws NoSuchElementException {
                Container<E> container = lastElement;
                if (hasNext()) {
                    for (int i = size - 1; i > iteratorSize; i--) {
                        container = container.previous;
                    }
                    iteratorSize++;
                } else {
                    throw new NoSuchElementException();
                }
                return container.value;
            }
        };
    }

    /**
     * Класс-обертка над любым объектом.
     * @param <V>
     */
    static class Container<V> {

        Container<V> previous;
        V value;

        public Container(V value) {
            this.value = value;
        }
    }
}
