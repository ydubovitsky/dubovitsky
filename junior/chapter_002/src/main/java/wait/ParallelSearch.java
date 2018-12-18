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
         *
         */
        final boolean[] flag = new boolean[1];
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
                flag[0] = true;
            }
        };
        /**
         * Поток-потребитель; Пока производитель работает, работает и потребитель.
         */
        Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // Пока текущий поток не прерван
                try {
                    if (flag[0]) Thread.currentThread().interrupt();
                    queue.poll();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        /**
         * Запускаем потоки.
         */
        consumer.start();
        producer.start();
    }
}
