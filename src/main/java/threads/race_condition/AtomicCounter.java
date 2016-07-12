package threads.race_condition;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bbb1991 on 7/13/16.
 */
public class AtomicCounter implements ICounter {

    private AtomicInteger counter;

    public AtomicCounter() {
        this.counter = new AtomicInteger();
    }

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public int getValue() {
        return counter.get();
    }
}
