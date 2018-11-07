package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<e> implements Iterable{

    /**
     * Размер листа; Динамически увеличивается.
     */
    private int size = 0;

    /**
     * Хранилище элементов.
     */
    private Element<e>[] list = new Element[0];

    /**
     * Счетчик модификаций коллекции.
     */
    private int modCount = 0;

    /**
     * Метод добавляет новый элемент в хранилище и производит связывание элементов.
     * Т.е. каждый элемент хранит в себе ссылку на соседние элементы.
     * При достижении максимального числа элементов в массиве, создается временный массив
     * и расширяется старый за счет нового.
     * @param value
     */
    public void add(e value) {
        Element element = new Element(value);
        if (list.length == 0) {
            list = new Element[list.length + 10];
            list[size++] = element;
            element.previous = element;
            modCount++; // Увеличиваем счетчик модификаций
        }
        else if (list.length - 1 > size) {
            element.previous = list[size];
            list[size++] = element;
        }
        // Расширяется лист и создается временнный масссив.
        else if (list.length - 1 == size && size > 0) {
            Element<e>[] temp = new Element[list.length + 10];
            System.arraycopy(list, 0, temp, 0, list.length);
            element.previous = list[size];
            temp[size++] = element;
            modCount++; // Увеличиваем счетчик модификаций
            list = temp;
        }
    }

    /**
     * Метод возвращает элемент из листа, если индекс существует
     * @param index
     * @return
     */
    public e get(int index) {
        return index <= this.size? list[index].value : null;
    }

    /**
     * Метод заменяет элемент из листа на элемент из метода.
     * @param index
     * @param element
     */
    public void set(int index, e element) {
        if (index <= this.size) {
            list[index] = new Element<>(element);
        }
    }

    /**
     * Собственный итератор для Листа.
     * @return
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            /**
             * Индекс для итератора.
             */
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.length;
            }

            @Override
            public Object next() {
                if (!hasNext() || modCount > 0) {
                    throw new ConcurrentModificationException("Лист претерпел изменения");
                }
                return list[index++].value;
            }
        };
    }


    /**
     * Класс обертка над елементами, добавляемыми в Лист.
     * @param <e>
     */
    static class Element<e> {

        /**
         * Ссылка на предыдущий элемент листа.
         */
        private e previous;

        /**
         * Значение элемента.
         */
        private e value;

        /**
         * Индекс элемента; 0 по умолчанию.
         */
        private static int index = 0;

        /**
         * Конструтокр, создает новый элемент и увеличивает индекс.
         * @param value
         */
        public Element(e value) {
            this.value = value;
            index++;
        }
    }
}

