//package wait;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.stream.IntStream;
//
//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
//
///**
// * Тестовый класс.
// */
//public class BlockQueueTest {
//    @Test
//    public void whenFetchAllThenGetIt() throws InterruptedException {
//        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
//        final BlockQueue<Integer> queue = new BlockQueue<>();
//        Thread producer = new Thread(
//                () -> {
//                    IntStream.range(0, 5).forEach(
//                            queue::offer
//                    );
//                }
//        );
//        producer.start();
//        Thread consumer = new Thread(
//                () -> {
//                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
//                        try {
//                            buffer.add(queue.poll());
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                }
//        );
//        consumer.start();
//        producer.join();
//        consumer.interrupt();
//        consumer.join();
//        Assert.assertEquals(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
//    }
//}