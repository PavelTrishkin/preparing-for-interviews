package ru.trishkin.gb.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private int value;
    private Lock lock = new ReentrantLock();

    public LockCounter() {
        this.value = 0;
    }

    public void increment(){
        try {
            lock.lock();
            value++;
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        try {
            lock.lock();
            value--;
        }finally {
            lock.unlock();
        }
    }

    public int getValue(){
        return value;
    }
}
