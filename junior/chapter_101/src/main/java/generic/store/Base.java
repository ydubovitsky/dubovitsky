package generic.store;

/**
 * Базовый абстрактный класс.
 */
public abstract class Base {

    /**
     * id
     */
    private final String id;

    /**
     * Конструктор.
     * @param id
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Геттер для id.
     * @return
     */
    public String getId() {
        return id;
    }
}
