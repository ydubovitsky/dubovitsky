package generic.store;

import generic.SimpleArray;

/**
 * Класс-контейнер для объектов класс Role.
 */
public class RoleStore extends SimpleArray<Role> {

    /**
     * Конструктор, принимающий количество элементов массива.
     * @param index
     */
    public RoleStore(int index) {
        super(index);
    }
}
