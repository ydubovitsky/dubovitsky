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
         * Флаг, показывающий состояние потока.
         */
        final boolean[] flag = new boolean[1];
        /**
         * Поток, добавляющий элементы в очередь.
         */
        final Thread producer = new Thread() {
            public void run() {
                for (int index = 0; index != 3; index++) {
                    queue.offer(index);
                    try {
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
            while (producer.isAlive() || !flag[0]) { // Пока поток производитель запущен или флаг = false;
                queue.poll();
                try {
                    Thread.sleep(1000);
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
