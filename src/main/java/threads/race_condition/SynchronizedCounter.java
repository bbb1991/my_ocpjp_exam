package threads.race_condition;

/**
 * Created by bbb1991 on 7/13/16.
 * Снихронизирован. Потокобезопасен
 */
public class SynchronizedCounter implements ICounter {

    private int count;
    private static final Object lock = new Object();

    @Override
    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    @Override
    public int getValue() {
        return count;
    }
}
