package wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Это блокирующая очередь, ограниченная по размеру.
 * В данном шаблоне Producer помещает данные в очередь, а Consumer извлекает данные из очереди.
 * @param <E>
 */
@ThreadSafe
class Queue<E> {
    /**
     * Очередь размером 7.
     */
    @GuardedBy("this")
    E[] queue = (E[]) new Object[7];

    /**
     * Размерность очереди
     */
    volatile Integer count = 0;

    /**
     * Добавляет объект в очередь.
     */
    public synchronized void put(E e) {
        while (count == queue.length) { // Пока очередь не заполнена
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        queue[count] = e;
        System.out.println("Output: " + queue[count]);
        count++;
        notifyAll();
    }

    /**
     * Получаем элемент из очереди.
     *
     * @return
     */
    public synchronized E get() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        count--;
        E result = queue[count];
        System.out.println("Output: " + result);
        notifyAll();
        return result;
    }
}

