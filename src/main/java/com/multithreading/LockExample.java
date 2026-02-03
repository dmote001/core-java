package com.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockExample {

    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(()-> {
            for(int i = 0 ; i < 100 ; i++){
                account.withDrawAmount(25);
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i = 0 ; i < 100 ; i++){
                account.withDrawAmount(25);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class BankAccount{

    private int balance = 1000;

    Lock lock = new ReentrantLock();

    public  void withDrawAmount(int amount) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) { // t0 -> t1
                try{
                    if (balance > 0) {
                        balance = balance - amount;
                        sleep(100);
                        System.out.println("Amount Withdrawn -- " + amount + " Account Balance --" + balance + " Thread -- " + Thread.currentThread().getName());
                    }
                    else {
                        System.out.println("Insufficient Account Balance --" + balance + " Thread -- " + Thread.currentThread().getName());
                    }
                }
                catch (Exception e){
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
        }
        else{
            System.out.println(" Did not found lock Thread -- " + Thread.currentThread().getName());
        }
    } catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }

}


/*
*
* Locking :
*   1) Intrinsic -  Synchronisation -> JVM
*
*   [t1] <- t2, t3
*.
*
*   2) Extrinsic - trylock, release
*
*  ReentrantLock
*  ReadWriteLock
*
*
*
*
* */