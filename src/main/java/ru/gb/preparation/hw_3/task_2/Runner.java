package ru.gb.preparation.hw_3.task_2;

import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
//        Calculation without blocking
        Counter counter = new Counter(0);
        compute(counter::increment);
        System.out.println("Without:\t" + counter.getVal());

//        Calculation with blocking
        counter.setVal(0);
        compute(counter::concurrenceIncrement);
        System.out.println("With   :\t" + counter.getVal());
    }

    private static void compute(Runnable method) {
        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(method));
            threads.getLast().start();
        }
        for (Thread t : threads) {
            join(t);
        }
    }

    private static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
