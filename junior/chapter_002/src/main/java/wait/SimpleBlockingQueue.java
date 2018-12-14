package wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Это блокирующая очередь, ограниченная по размеру.
 * В данном шаблоне Producer помещает данные в очередь, а Consumer извлекает данные из очереди.
 * @param <E>
 */
@ThreadSafe
public class SimpleBlockingQueue<E> {

    Queue<Integer> queue = new Queue<>();

    public SimpleBlockingQueue() {
        new Producer(queue);
        new Consumer(queue).start();
    }

    public static void main(String[] args) {
        new SimpleBlockingQueue<>();
    }

    /**
     * Класс поставщик.
     */
    class Producer implements Runnable {
        Queue<E> queue;
        Thread thread;

        public Producer(Queue queue) {
            this.queue = queue;
            thread = new Thread(this, "Producer");
            thread.start();
        }

        public void run() {
            Integer i = 0;
            while (true) {
                queue.put((E)i);
                i++;
            }
        }
    }

    /**
     * Класс потребитель.
     */
    class Consumer extends Thread {
        Queue<E> queue;

        public Consumer(Queue queue) {
            super("Consumer");
            this.queue = queue;
        }

        public void run() {
            while (true) {
                queue.get();
            }
        }

    }

    /**
     * Потокобезопасная очередь.
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
        int count = 0;

        /**
         * Переменная
         */
        boolean start = false;

        /**
         * Добавляет объект в очередь.
         */
        public synchronized void put(E e) {
            while (start) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            queue[count] = e;
            System.out.println("Insert into queue: " + queue[count]);
            count++;
            start = true;
            notify();
        }

        /**
         * Получаем элемент из очереди.
         * @return
         */
        public synchronized E get() {
            while (!start) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            count--;
            E result = queue[count];
            System.out.println("Output: " + result);
            start = false;
            notify();
            return result;
        }
    }
}

