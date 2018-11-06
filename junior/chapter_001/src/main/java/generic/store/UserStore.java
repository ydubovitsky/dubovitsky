package generic.store;

/**
 * Класс-контейнер для объектов класса User.
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Конструкто, задающий размер хранилища.
     * @param index
     */
    public UserStore(int index) {
        super(index);
    }
}
