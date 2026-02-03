package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockExample {

    public static void main(String[] args) throws InterruptedException {

        OuterInnerExample outerInnerExample = new OuterInnerExample();
        Runnable runnable = () -> {

            for (int i = 0 ; i< 10 ; i++){
                outerInnerExample.outter();
            }

        };


        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class OuterInnerExample{

    Lock lock = new ReentrantLock(true);

    public void outter(){
        lock.lock();
        System.out.println(" I am in outer");
        inner();
        lock.unlock();

    }

    public void inner(){
        lock.lock();
        System.out.println(" I am in inner");
        lock.unlock();
    }
}