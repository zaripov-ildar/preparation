package ru.gb.preparation.hw_1;

public class ArrList<T> implements iList<T> {

    private Object[] array;
    private final int INITIAL_SIZE = 10;
    private int lastElement = 0;

    public ArrList(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size can't be less then 0:" + size);
        this.array = new Object[size];
    }

    public ArrList() {
        this.array = new Object[INITIAL_SIZE];
    }

    @Override
    public void add(T t) {
        checkSize();
        array[lastElement] = t;
        lastElement++;
    }

    @Override
    public void add(int i, T t) {
        checkIndex(i);
        checkSize();
        System.arraycopy(array, i, array, i + 1, lastElement);
        array[i] = t;
        lastElement++;
    }

    private void checkSize() {
        if (lastElement >= array.length - 1) {
            increaseArray();
        }
    }

    private void increaseArray() {
        Object[] newArray = new Object[array.length << 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public boolean remove(T t) {
        int index = indexOf(t);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int i) {
        checkIndex(i);
        final Object o = array[i];
        System.arraycopy(array, i + 1, array, i, lastElement);
        lastElement--;
        return (T) o;

    }

    private void checkIndex(int i) {
        if (i < 0 || i >= lastElement) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int i) {
        checkIndex(i);
        return (T) array[i];
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < lastElement; i++) {
            if (array[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return lastElement;
    }

    public int getCapacity() {
        return array.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastElement; i++) {
            sb.append(array[i].toString()).append(" ");
        }
        return sb.toString();
    }
}

