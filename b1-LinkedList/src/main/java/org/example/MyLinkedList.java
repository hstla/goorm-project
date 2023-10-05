package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    transient Node<T> first;

    transient Node<T> last;

    private int size = 0;

    public MyLinkedList() {
    }


    public void add(T item) {
        final Node<T> end = last;
        final Node<T> newNode = new Node<>(end, item, null);
        last = newNode;
        if (end == null) {
            first = newNode;
        } else {
            end.setNext(newNode);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T get(int index) {
        extracted(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getItem();
    }

    public void delete(int index) {
        extracted(index);
        if (index == 0) {
            first = first.getNext();
        } else if (index == size - 1) {
            if (last.getPrev() != null) {
                last.getPrev().setNext(null);
            }
            last = last.getPrev();
        } else {
            Node<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    private void extracted(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("인덱스가 작거나 큽니다.");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.getItem());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // 맨 처음부터 순회
            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                // 다음이 있는지 먼저 확인하고, 있으면 동작
                if (!hasNext()) {
                    throw new NoSuchElementException("다음은 없어요.");
                }
                T data = current.getItem();
                current = current.getNext();
                return data;
            }
        };
    }
}
