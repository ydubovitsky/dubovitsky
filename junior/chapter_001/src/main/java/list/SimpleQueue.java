package list;

/**
 * Queue - очередь. Описывается FIFO - first input first output.
 * Внутри очереди нужно используются Стеки - list.SimpleStack.
 * @param <T>
 */
public class SimpleQueue<T> {

    /**
     * Два Стек-контейнера.
     */
    private SimpleStack<T> simpleStack;
    private SimpleStack<T> temp;

    /**
     * Количество добавленных элементов.
     */
    private int addedElementsCount = 0;

    /**
     * Конструктор.
     */
    public SimpleQueue() {
        simpleStack = new SimpleStack<>();
        temp = new SimpleStack<>();
    }

    /**
     * Возвращает значение и удалять его из коллекции.
     * Так как метод стека poll() возвращает головной элемент, мы создаем новый реверсивный стек и возвращаем элемент.
     * Затем делаем обратный реверс.
     */
    public T poll() {
        T result = null;
        for (int i = 0; i < addedElementsCount; i++) {
            temp.push(this.simpleStack.poll());
        }
        result = temp.poll();
        addedElementsCount--;
        for (int i = 0; i < addedElementsCount; i++) {
            simpleStack.push(temp.poll());
        }
        return result;
    }

    /**
     * Добавляем новый элемент.
     * @param value
     */
    public void push(T value) {
        this.simpleStack.push(value);
        this.addedElementsCount++;
    }
}
