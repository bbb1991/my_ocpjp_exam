package threads.race_condition;

/**
 * Created by bbb1991 on 7/13/16.
 */
public class MyThread extends Thread {

    private ICounter counter;
    private int var;

    public MyThread(final ICounter counter, int var) {
        this.counter = counter;
        this.var = var;
    }

    @Override
    public void run() {
        for (int i = 0; i < var; i++) {
            counter.increment();
        }
    }
}
