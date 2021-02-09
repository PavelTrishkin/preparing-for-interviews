package ru.trishkin.gb.lesson2;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement);
        firstElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }

        Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }
}
