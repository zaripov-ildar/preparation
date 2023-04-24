package ru.gb.preparation.hw_3.deadlock;

public class DeadLock {
    public static void main(String[] args) {
        final Object SOURCE_1 = new Object();
        final Object SOURCE_2 = new Object();
        new BadThread(SOURCE_1, SOURCE_2, "first");
        new BadThread(SOURCE_2, SOURCE_1, "second");
    }
}
