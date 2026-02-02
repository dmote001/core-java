package com.multithreading;

public class ThreadExample extends Thread {

    public ThreadExample(String name) {
        super(name);
    }

    @Override
    public void run(){
        System.out.println("thread is in run..!!");

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(

                            "thread id - " + Thread.currentThread().threadId() +
                                    "thread name - " + Thread.currentThread().getName() +
                                    "thread priority - " + Thread.currentThread().getPriority()

                    );
                    sleep(0);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }

        System.out.println("thread is out of run..!!");
    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadExample t1 = new ThreadExample("t1");
//        t1.setPriority(1);
//
//        ThreadExample t2 = new ThreadExample("t2");
//        System.out.println(t1.getState()); // NEW
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println(t1.getState()); // TERMINATED
//        System.out.println(t2.getState()); // RUNNABLE


        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
                System.out.println("Notification sent");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread awakened 2");
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread awakened 3");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}


/*
*
*  cpu - is the brain of computer.
*   multi tasking -

* DOS - cores single -> task switching
*
* processors - [cores single, multi, octa etc.]

task -> process -> [multi processing] -> parallelism

*
*  JVM ->
*
*
*    Thread - [
*           - process
* ]
*
* Naming of thread -
* Priority of threads - 0 Low - 5 Medium and default - 10 high
*
* thread life cycle - New, Runnable, Running, Terminate
*
* synchronised
* deadlock - db | os
*
*
* starvation -
* t1 t2 t3 t2 t1 t3 t4
*
* 1000 ->
* mutlithreading t1..t4 -> 100
*
* 1000rs
*
* t1 t2 t3 t4
*
* t1 - 400 notify to t2
* t2 - 300 waiting for t1 -> notify to t3
* t3 - 300 waiting for t2 -> notify to t4
* t4 - 0  state of starvation
*
*
*
* t1 - 400 notify to t2, t3, t4
* t2 - 300 waiting for t1 -> notify to t3, t4
* t3 - 150 waiting for t2 -> notify to t4
* t4 - 150 finish
*
* */