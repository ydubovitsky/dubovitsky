package generic.store;

/**
 * Обобщенный интерфейс.
 * @param <T>
 */
public interface Store<T extends Base> {

    /**
     * Добавляем элемент в хранилище.
     * @param model
     */
    void add(T model);

    /**
     * Замена элемента в хранилище
     * @param id
     * @param model
     * @return
     */
    boolean replace(String id, T model);

    /**
     * Удаление элемента из хранилища
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * Ищем элемент по id.
     * @param id
     * @return
     */
    T findById(String id);
}
