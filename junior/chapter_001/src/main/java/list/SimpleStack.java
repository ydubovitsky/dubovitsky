package list;

import java.lang.reflect.Field;

/**
 * Контейнер Stack
 * LIFO - last input first output.
 */
public class SimpleStack<T> extends ContainerShow<T> {

    /**
     * Последний добавленыый элемент в стек.
     */
    private ContainerShow<T> containerShow;

    /**
     * Последний добавленыый элемент.
     */
    private Container<T> lastElement;

    /**
     * Конструктор
     */
    public SimpleStack() {
        containerShow = new ContainerShow<>();
    }

    /**
     * Возвращает значение и удалять его из коллекции.
     */
    public T poll() {
        T result = this.lastElement.value;
        delete();
        return result;
    }

    /**
     * Добавляет элемент в коллекцию.
     * @param value
     */
    public void push(T value) {
        containerShow.add(value);
        try { // Используем рефлексию для доступа к приватным полям.
            Field field = this.containerShow.getClass().getDeclaredField("lastElement");
            field.setAccessible(true);
            this.lastElement = (Container) field.get(containerShow);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Удаляем последний добавленный элемент.
     */
    public void delete() {
        this.lastElement = this.lastElement.previous; // Ссылке на последний элемент присваивается ссылка на предпоследний объект.
    }
}
