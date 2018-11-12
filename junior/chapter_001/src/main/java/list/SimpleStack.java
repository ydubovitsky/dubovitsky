package list;

/**
 * Контейнер Stack
 * LIFO - last input first output.
 */
public class SimpleStack<T> {

    /**
     * Количество добавленных элементов
     */
    private int elementsCount = -1;

    /**
     * Контейнер
     */
    private DynamicСontainerBasedOnLinkedList<T> container;

    /**
     * Конструктор
     */
    public SimpleStack() {
        container = new DynamicСontainerBasedOnLinkedList<>();
    }

    /**
     * Возвращает значение и удалять его из коллекции.
     */
    public T poll() {
        T result = this.container.get(elementsCount);
        this.container.delete(elementsCount);
        elementsCount--;
        return result;
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param value
     */
    public void push(T value) {
        this.container.add(value);
        this.elementsCount++;
    }
}
