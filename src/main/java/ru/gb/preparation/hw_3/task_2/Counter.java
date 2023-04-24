package ru.gb.preparation.hw_3.task_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int val;
    private static final Lock lock = new ReentrantLock();

    public Counter(int val) {
        this.val = val;
    }

    public void concurrenceIncrement() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void increment(){
        for (int i = 0; i < 10_000; i++) {
            val++;
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
