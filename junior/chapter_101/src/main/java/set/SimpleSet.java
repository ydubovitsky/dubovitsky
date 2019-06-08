package set;

import list.DynamicListBasedOnArray;

import java.util.Iterator;

/**
 * Коллекция Set на массиве.
 * Коллекция обеспечивает void add(E e) и реализует Iterable<E>.
 * Коллекция не хранит дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 */
public class SimpleSet<E> implements Iterable<E> {

    /**
     * Простой лист, реализованный на массиве.
     */
    private DynamicListBasedOnArray<E> simpleList;

    /**
     * Количество добавленных элементов.
     */
    private int count = 0;

    /**
     * Конструктор.
     */
    public SimpleSet() {
        simpleList = new DynamicListBasedOnArray<E>();
    }

    /**
     * Добавляем элемент в множество с проверкой на дублирование.
     * При проверке на дублирование, происходит обход всего множества,
     * и каждый элемент проверяется на эквивалентность с добавляемым E e элементом.
     * @param e
     */
    public boolean add(E e) throws NoSuchMethodException {
        E temp;
        boolean result = true;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                temp = (E) simpleList.get(i);
                if (temp.equals(e)) {
                    result = false;
                }
            }
        } if (count == 0 || result) {
            simpleList.add(e);
            count++;
        }
        return result;
    }

    /**
     * Итератор.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
