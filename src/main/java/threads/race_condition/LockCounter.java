package threads.race_condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bbb1991 on 7/13/16.
 */
public class LockCounter implements ICounter {
    private Lock lock = new ReentrantLock();

    private int count;

    @Override
    public void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    @Override
    public int getValue() {
        return count;
    }
}
