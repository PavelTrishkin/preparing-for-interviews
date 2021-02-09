package ru.trishkin.gb.lesson2;

public class MyArrayList<E> {
    private static final int BASE_CAPACITY = 10;
    private int size;
    private E[] elementData;

    public MyArrayList(int newCapacity) throws Exception {
        if (newCapacity > 0){
            this.elementData = (E[]) new Object[newCapacity];
        } else if (newCapacity == 0){
            this.elementData = (E[]) new Object[BASE_CAPACITY];
        } else {
            throw new Exception("Capacity < 0");
        }
    }

    public MyArrayList() {
        this.elementData = (E[]) new Object[BASE_CAPACITY];
    }

    public boolean add(E item){
        elementData[size++] = item;
        return true;
    }

    public boolean remove(int index) throws Exception {
        if (size < index || index < 0){
            return false;
        }
        int moves = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, moves);
        return true;
    }
}
