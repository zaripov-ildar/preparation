package ru.gb.preparation;

public interface iList<T> {
    void add(T t);

    void add(int i, T t);

    boolean remove(T t);

    T remove(int i);

    T get(int i);

    boolean contains(T t);

    int indexOf(T t);

    int size();
}
