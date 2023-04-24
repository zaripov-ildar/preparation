package ru.gb.preparation.hw_2;

public class Node<T> {

    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
    }

    public Node(T val, Node<T> left, Node<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
