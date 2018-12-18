package wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Это блокирующая очередь, ограниченная по размеру.
 * В данном шаблоне Producer помещает данные в очередь, а Consumer извлекает данные из очереди.
 * @param <E>
 */
@ThreadSafe
class BlockQueue<E> {
    /**
     * Очередь размером 7.
     */
    @GuardedBy("this")
    private final Queue<E> list = new LinkedList<>();

    /**
     * Размерность очереди
     */
    private int maxSize = 5;

    /**
     * Добавляет объект в очередь.
     */
    public synchronized void offer(E e) {
        while (list.size() == maxSize) { // Пока очередь не заполнена
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        list.add(e);
        System.out.println("Input " + e);
        notifyAll();
    }

    /**
     * Получаем элемент из очереди.
     * @return
     */
    public synchronized E poll() {
        while (list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        E result = list.poll();
        System.out.println("Output: " + result);
        notifyAll();
        return result;
    }
}


