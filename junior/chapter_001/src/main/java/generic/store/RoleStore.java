package generic.store;

import generic.SimpleArray;

/**
 * Класс-контейнер для объектов класс Role.
 */
public class RoleStore extends AbstractStore {

    /**
     * Хранилище объектов типа T extends Role.
     */
    private SimpleArray<Role> simpleArray;

    /**
     * Конструкто, задающий размер хранилища.
     *
     * @param index
     */
    public RoleStore(int index) {
        simpleArray = new SimpleArray(index);
    }
}
