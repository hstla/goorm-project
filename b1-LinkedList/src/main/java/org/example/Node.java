package org.example;

public class Node<T> {
    private T item;
    private Node<T> next;
    private Node<T> prev;

    Node(Node<T> prev, T element, Node<T> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }


    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }
}