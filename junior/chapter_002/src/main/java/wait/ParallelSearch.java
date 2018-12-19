package wait;

/**
 * Параллельный поиск
 */
public class ParallelSearch {

    public static void main(String[] args) {
        /**
         * Блокирующая очередь
         */
        BlockQueue<Integer> queue = new BlockQueue<Integer>();
        /**
         * Поток-потребитель; Пока производитель работает, работает и потребитель.
         */
        Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // Пока текущий поток не прерван
                try {
                    queue.poll();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        /**
         * Запускаем поток потребитель;
         */
        consumer.start();
        /**
         * Поток, добавляющий элементы в очередь.
         */
        final Thread producer = new Thread() {
            public void run() {
                for (int index = 0; index != 3; index++) {
                    try {
                        queue.offer(index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumer.interrupt();
            }
        };
        /**
         * Запускаем поток производитель.
         */
        producer.start();
    }
}
