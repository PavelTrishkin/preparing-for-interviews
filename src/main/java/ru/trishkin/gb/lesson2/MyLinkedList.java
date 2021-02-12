package ru.trishkin.gb.lesson2;

public interface MyLinkedList<E> {
    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    int size();

    boolean isEmpty();

    E getFirst();

    class Node<E>{
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
