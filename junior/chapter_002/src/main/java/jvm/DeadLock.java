package jvm;

/**
 * Наглядно показана реализация взаимной блокировки.
 */
public class DeadLock implements Runnable {
    Thread thread;
    Producer producer = new Producer();
    Consumer consumer = new Consumer();

    public DeadLock() {
        thread = new Thread(this, Thread.currentThread().getName());
        thread.start();
        producer.producerMethod(consumer);
    }

    public void run() {
        consumer.consumerMethod(producer);
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}

class Producer {
    public synchronized void producerMethod(Consumer consumer) {
        System.out.println("Внутри метода producerMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        consumer.C();
    }

    public synchronized void P() {
        System.out.println("Внутри метода P");
    }
}

class Consumer {
    public synchronized void consumerMethod(Producer producer) {
        System.out.println("Внутри метода consumerMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        producer.P();
    }

    public synchronized void C() {
        System.out.println("Внутри метода C");
    }
}