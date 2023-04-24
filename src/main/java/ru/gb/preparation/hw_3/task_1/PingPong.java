package ru.gb.preparation.hw_3.task_1;

public class PingPong extends Thread {

    private static boolean isPingTurn;
    private final boolean isPing;
    private static final Object lock = new Object();
    private final int TIMES = 20;

    public PingPong(boolean isPing) {
        this.isPing = isPing;
        isPingTurn = true;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            synchronized (lock) {
                if (isPingTurn != isPing) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(isPing ? "ping-" : "pong\n");
                isPingTurn = !isPingTurn;
                lock.notify();
            }
        }
    }
}
