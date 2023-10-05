package org.example;

public class MyQueue<T> {

    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.add(item);
    }


    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("queue가 비었다.");
        }
         T frontItem = list.get(0);
        list.delete(0);
        return frontItem;
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("queue가 비었다.");
        }
        return list.get(0);
    }
}
