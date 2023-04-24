package ru.gb.preparation.hw_3.deadlock;

public class BadThread extends Thread{
    private final Object o1;
    private final Object o2;

    private final String name;

    public BadThread(Object o1, Object o2, String name) {
        this.o1 = o1;
        this.o2 = o2;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println("Hi from the " + name);
            }
        }
    }
}
