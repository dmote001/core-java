package com.multithreading;


public class RunnableExample{

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i =0 ; i<100 ; i++){
                System.out.println(

                        "thread id - " + Thread.currentThread().threadId() +
                                "thread name - " + Thread.currentThread().getName() +
                                "thread priority - " + Thread.currentThread().getPriority()

                );
            }
        };

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);
        Thread th3 = new Thread(runnable);

        th1.start();
        th2.start();
        th3.start();

    }
}


