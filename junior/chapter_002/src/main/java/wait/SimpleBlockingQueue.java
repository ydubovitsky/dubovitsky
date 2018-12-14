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

    private Queue<Integer> queue = new Queue<>();

    public SimpleBlockingQueue() {
        new Consumer(queue, "Получатель 1").start();
        new Producer(queue, "Поставщик 1 ");
        new Producer(queue, "Поставщик 2 ");
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

        public Producer(Queue queue, String name) {
            this.queue = queue;
            thread = new Thread(this, name);
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

        public Consumer(Queue queue, String name) {
            super(name);
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
        volatile Integer count = 0;

        /**
         * Переменная
         */
        volatile boolean start = false;

        /**
         * Добавляет объект в очередь.
         */
        public synchronized void put(E e) {
            while (start && count >= queue.length) { // Пока происходит чтение или очередь не заполнена
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            queue[count] = e;
            System.out.println("Insert into queue: " + queue[count]);
            int temp;
            synchronized (this.count){
                temp = this.count;
            }
            temp++;
            synchronized (this.count) {
                this.count = temp;
            }
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
            int temp;
            synchronized (this.count){
                temp = this.count;
            }
            temp--;
            synchronized (this.count) {
                this.count = temp;
            }
            E result = queue[count];
            System.out.println("Output: " + result);
            start = false;
            notify();
            return result;
        }
    }
}

