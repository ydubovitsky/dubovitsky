package wait;

import org.junit.Before;
import org.junit.Test;

/**
 * Тестовый класс.
 */
public class QueueTest {

    Queue queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void whenWorkingThreeProducerAndOneConsumer() {
        new Producer<Integer>(this.queue, "Производитель 1");
        new Producer<Integer>(this.queue, "Производитель 2");
        new Consumer<Integer>(this.queue, "Получатель 1");
    }

    /**
     * Класс поставщик.
     */
    class Producer<E> implements Runnable {
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
    class Consumer<E> extends Thread {
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
}