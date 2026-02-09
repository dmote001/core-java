package com.multithreading;

public class WaitNotifyExample {

//    private int num = 1;

    synchronized void printOdd() {
        for (int num = 0; num <= 100; num++ ) {
            if (num % 2 == 1) {
                System.out.println( "Thread -- "+ Thread.currentThread().getName() +  " Odd:  " + num);
                notify();
            } else {
                try {
                    System.out.println(" i am in odd"+ Thread.currentThread().getName() + " num "+ num);
                    wait(1000);
                } catch (InterruptedException e) {}
            }
        }
    }

    synchronized void printEven() {
        for (int num = 0; num <= 100; num++) {
            if (num % 2 == 0) {
                System.out.println("Thread -- "+ Thread.currentThread().getName() + " Even: " + num);
                notify();
            } else {
                try {
                    System.out.println(" i am in even"+ Thread.currentThread().getName() + " num "+ num);
                    wait(1000);
                } catch (InterruptedException e) {}
            }
        }
    }
}

class Main {
    public static void main(String[] args) {

        WaitNotifyExample obj = new WaitNotifyExample();

        Thread t1 = new Thread(obj::printOdd);
        Thread t2 = new Thread(obj::printEven);

        t1.start();
        t2.start();
    }
}
/*
*  [] []
*
*
*
*
* */
