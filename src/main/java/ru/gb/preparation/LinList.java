package ru.gb.preparation;

public class LinList<T> implements iList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinList() {
        size = 0;
    }

    @Override
    public void add(T t) {
        addLast(t);
    }

    public void addLast(T t) {
        Node<T> temp = tail;
        Node<T> node = new Node<T>(t, temp, null);
        tail = node;
        if (temp == null) {
            head = node;
        } else {
            temp.right = node;
        }
        size++;
    }

    @Override
    public boolean remove(T t) {
        Node<T> temp = head;
        if (t == null) {
            while (temp != null) {
                if (temp.val == null) {
                    delete(temp);
                    return true;
                }
                temp = temp.right;
            }
        } else {

            while (temp != null) {
                if (temp.val.equals(t)) {
                    delete(temp);
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;
    }

    private T delete(Node<T> temp) {
        T val = temp.val;
        Node<T> l = temp.left;
        Node<T> r = temp.right;

        if (l == null) {
            head = r;
        } else {
            l.right = r;
            temp.left = null;
        }

        if (r == null) {
            tail = l;
        } else {
            r.left = l;
            temp.right = null;
        }
        temp.val = null;
        size--;
        return val;
    }

    @Override
    public T remove(int i) {
        checkIndex(i);
        return delete(findByIndex(i));
    }

    private Node<T> findByIndex(int index) {
        // if index less then half size than start from the head else from the tail
        Node<T> temp;
        if (index < (size >> 1)) {
            temp = head;
            for (int j = 0; j < index; j++) {
                temp = temp.right;
            }

        } else {
            temp = tail;
            for (int j = size - 1; j > index; j--) {
                temp = temp.left;
            }

        }
        return temp;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i);
        }
    }

    @Override
    public T get(int i) {
        checkIndex(i);
        return findByIndex(i).val;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public void add(int i, T t) {
        checkIndex(i);
        if (i == size) {
            addLast(t);
        } else {
            Node<T> node = findByIndex(i);

            Node<T> l = node.left;
            Node<T> newNode = new Node<T>(t, l, node);
            node.left = newNode;
            if (l == null) {
                head = newNode;
            } else {
                l.right = newNode;
            }
            size++;
        }
    }

    @Override
    public int indexOf(T t) {
        int index = 0;
        Node<T> temp = head;
        if (t == null) {
            while (temp != null) {
                if (temp.val == null) {
                    return index;
                }
                temp = temp.right;
                index++;
            }
        } else {
            while (temp != null) {
                if (temp.val.equals(t)) {
                    return index;
                }
                temp = temp.right;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.val.toString()).append(" ");
            temp = temp.right;
        }
        return sb.toString();
    }
}

