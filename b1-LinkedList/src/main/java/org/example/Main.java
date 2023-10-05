package org.example;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(list.size());
        list.delete(3);
        System.out.println(list.get(2));
        System.out.print("[");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}