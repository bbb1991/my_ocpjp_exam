package threads;

/**
 * Потоки можно создавать двумя способами.
 *  1. Имплементация интерфейса Runnable
 *  2. Наследование класса Thread
 */
public class ThreadsExample {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Runnable r1 = new MyThread2();

        t1.start();
        new Thread(r1).start();
    }
}

class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Extends from Thread class");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Implements runnable interface");
    }
}