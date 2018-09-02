import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IncrementSynchronize {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock writeLock = rwl.writeLock();
    private int value = 0;

    public synchronized int getNextValue1(){
        value++;
        return value;
    }

    public int getNextValue2()throws InterruptedException{
        writeLock.lock();
        try {
            value++;
        } finally {
            writeLock.unlock();
        }

        return value;
    }

    public int getNextValue3(){
        synchronized(new Object()) {value++;}
        return value;
    }

    public int getValue() {
        return value;
    }
}
