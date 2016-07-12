package threads.race_condition;

import org.junit.Assert;
import org.junit.Test;

public class Application {
    /**
     * Пример одной из проблем многопоточного программирования - Race condition (режим состязания)
     * Когда потоки мешают друг другу.
     * Данный пример иллюстрирует данную проблему. есть операция инкремента (который работает в 3 шага
     * чтение, увеличение, запись). При запуске 2 и более потока одновременно, будут мешать и перезаписывать значения
     */

    public static final int ITERATE_COUNT = 1_000_000;

    private int counterTest(ICounter counter) throws InterruptedException {
        Thread t1 = new MyThread(counter, ITERATE_COUNT);
        Thread t2 = new MyThread(counter, ITERATE_COUNT);

        t1.start();
        t2.start();

        t2.join();

        return counter.getValue();
    }

    @Test
    public void simpleCounterTest() throws InterruptedException {
        // простая реализация, есть проблемы с многопоточностью
        ICounter counter = new SimpleCounter();

        // здесь точно будет меньше чем вызовов
        Assert.assertNotEquals(ITERATE_COUNT * 2, counterTest(counter));
    }

    @Test
    public void synchronizedCounterTest() throws InterruptedException {
        // Синхронизирован. потоко безопасен
        ICounter counter = new SynchronizedCounter();
        Assert.assertEquals(ITERATE_COUNT * 2, counterTest(counter));
    }

    @Test
    public void atomicCounterTest() throws InterruptedException {
//        / Релизация с помощью AtomicInteger. Потокобезопасен
        ICounter counter = new AtomicCounter();

        Assert.assertEquals(ITERATE_COUNT * 2, counterTest(counter));
    }

    @Test
    public void lockCounterTest() throws InterruptedException {
        // Реализация с помощью Lock concurrent. Потокобезопасен
        ICounter counter = new LockCounter();

        Assert.assertEquals(ITERATE_COUNT * 2, counterTest(counter));
    }
 }
