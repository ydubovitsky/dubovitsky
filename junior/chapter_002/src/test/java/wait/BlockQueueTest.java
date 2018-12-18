package wait;

import org.junit.Before;
import org.junit.Test;

/**
 * Тестовый класс.
 */
public class BlockQueueTest {

    BlockQueue queue;

    @Before
    public void setUp() {
        queue = new BlockQueue<>();
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
        BlockQueue<E> queue;
        Thread thread;

        public Producer(BlockQueue queue, String name) {
            this.queue = queue;
            thread = new Thread(this, name);
            thread.start();
        }

        public void run() {
            Integer i = 0;
            while (true) {
                queue.offer((E)i);
                i++;
            }
        }
    }

    /**
     * Класс потребитель.
     */
    class Consumer<E> extends Thread {
        BlockQueue<E> queue;

        public Consumer(BlockQueue queue, String name) {
            super(name);
            this.queue = queue;
            this.start();
        }

        public void run() {
            while (true) {
                queue.poll();
            }
        }
    }
}