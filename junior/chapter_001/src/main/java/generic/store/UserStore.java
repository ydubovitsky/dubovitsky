package generic.store;

import generic.SimpleArray;

/**
 * Класс-контейнер для объектов класса User.
 */
public class UserStore extends SimpleArray<User> {

    /**
     * Конструктор, принимающий количество элементов массива.
     * @param index
     */
    public UserStore(int index) {
        super(index);
    }
}
