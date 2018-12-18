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
         * Два потока.
         */
        Thread producer;
        Thread consumer;
        /**
         * Поток-потребитель; Пока производитель работает, работает и потребитель.
         */
        consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // Пока поток производитель запущен;
                queue.poll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Поток Producer прервал выполнение потока Consumer");
                }
            }
        });
        /**
         * Поток, добавляющий элементы в очередь.
         */
        producer = new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                queue.offer(index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consumer.interrupt();
        });
        /**
         * Запускаем потоки.
         */
        producer.start();
        consumer.start();
    }

}
