package synchronize.list;

import list.DynamicListBasedOnArray;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadSafeListTest {

    ThreadSafeList threadSafeList;

    class Threads implements Runnable {
        Thread thread;
        /**
         * Имя потока.
         */
        String name;

        /**
         * Конструктор.
         * @param name
         */
        public Threads(String name) {
            this.name = name;
            thread = new Thread(this, this.name);
            thread.start();
        }

        public void run() {
            while (threadSafeList.iterator().hasNext()) {
                System.out.println("Поток " + this.name + " " + threadSafeList.iterator().next());
            }
        }
    }

    @Before
    public void setUp() throws Exception {
        threadSafeList = new ThreadSafeList(new DynamicListBasedOnArray());
        // Заполняем лист
        for (int i = 0; i < 3; i++) {
            System.out.println("Added " + i);
            threadSafeList.list.add(i);
        }
    }

    @Test
    public void iterator() throws Exception {
        Threads one = new Threads("Первый");
        Threads two = new Threads("Второй");
    }
}