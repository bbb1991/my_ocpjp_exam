package threads;

/**
 * Поток можно выполнить только один рза
 */
public class ThreadExample2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new MyThread(i).start();
        }
    }
}

class MyThread extends Thread {
    private int id;
    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running thread " + id);
    }
}
