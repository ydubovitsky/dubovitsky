package generic.store;

import generic.SimpleArray;

/**
 * Абстрактный класс.
 * @param <T>
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Хранилище объектов типа T extends Base.
     */
    private SimpleArray<T> simpleArray;

    /**
     * Конструкто, задающий размер хранилища.
     * @param index
     */
    public AbstractStore(int index) {
        simpleArray = new SimpleArray<>(index);
    }

    /**
     * Добавляем элемент в хранилище.
     * @param model
     */
    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    /**
     * Заменяем элемент под номер id, элементов model. Если изменения удачно, возвращаем true.
     * @param id
     * @param model
     * @return
     */
    @Override
    public boolean replace(String id, T model) {
        simpleArray.set(Integer.valueOf(id), model);
        return simpleArray.get(Integer.valueOf(id)) == model;
    }

    /**
     * Удаляем элемент, если удачно возвращаем true.
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        T previous = simpleArray.get(Integer.valueOf(id));
        simpleArray.delete(Integer.valueOf(id));
        return simpleArray.get(Integer.valueOf(id)) == previous;
    }

    /**
     * Ищем элемент в хранилище под id.
     * @param id
     * @return
     */
    @Override
    public T findById(String id) {
        return simpleArray.get(Integer.valueOf(id));
    }
}
