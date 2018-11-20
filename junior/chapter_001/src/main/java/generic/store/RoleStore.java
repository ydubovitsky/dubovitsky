package generic.store;

import generic.SimpleArray;

/**
 * Класс-контейнер для объектов класс Role.
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Хранилище объектов типа T extends Role.
     */
    private SimpleArray simpleArray;

    /**
     * Конструктор, задающий размер хранилища.
     * @param index
     */
    public RoleStore(int index) {
        super(index);
    }
}
