package threads.race_condition;

/**
 * Created by bbb1991 on 7/13/16.
 * Реализация простая. НЕ потоко безопасен
 */
public class SimpleCounter implements ICounter {

    private int count;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public int getValue() {
        return count;
    }
}
