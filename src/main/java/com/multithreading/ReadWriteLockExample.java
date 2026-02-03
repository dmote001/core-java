package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread write = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });
        Thread write1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });

        Thread read1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.getCounter();
            }
        });
        Thread read2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.getCounter();
            }
        });

        write1.start();
        write.start();
        read1.start();
        read2.start();

        write.join();
        write1.join();
        read1.join();
        read2.join();
    }
}


class Counter {

    int counter = 0;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

    public void increment() {
        try {
            writeLock.lock();
            counter++;
            System.out.println("Increment Counter -- " + counter + " Thread -- " + Thread.currentThread().getName());
        }
        finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        try{
            readLock.lock();
            System.out.println("Read Counter -- " + counter + " Thread -- " + Thread.currentThread().getName());
            return counter;
        }
        finally {
            readLock.unlock();
        }
    }
}