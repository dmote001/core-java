package com.singletone;

public class LazySingletone {
    private static LazySingletone instance;

    private LazySingletone() {
    }

    public static LazySingletone getInstance() {
        if (instance == null) {
            instance = new LazySingletone();
        }
        return instance;
    }

    // make thread safe singletone class
    public synchronized static LazySingletone getSynchronizedInstance() {
        if (instance == null) {
            instance = new LazySingletone();
        }
        return instance;
    }

    //* TO overcome this overhead make a Double-Checked Locking and making reference volatile.
    private static volatile LazySingletone dclInstance;

    public synchronized static LazySingletone getDCLInstance() {
        if (dclInstance == null) {
            synchronized(LazySingletone.class){
                dclInstance = new LazySingletone();
            }
        }
        return dclInstance;
    }

}

class main{
    public static void main(String[] args) {
//            LazySingletone lazySingletone1 = new LazySingletone(); // compiletime error : can not instantiate as the constructor is private
        LazySingletone instance = LazySingletone.getInstance();
        LazySingletone instance1 = LazySingletone.getInstance();

        System.out.println(instance == instance1); // true

        LazySingletone instance2 = LazySingletone.getSynchronizedInstance();
        LazySingletone instance3 = LazySingletone.getSynchronizedInstance();
        System.out.println(instance2 == instance3); // true
    }
}
/*
*  To make class singletone
*
* step 1 : static private ref of same class type.
* step 2:  private constructor - user are not allowed to create object out side the class.
* step 3:  method to fetch the object of same class type
*
* violations :
* LazySingletone will be violated in case of multithreading. As multiple thread may try to call getInstanse() and may raise a risk of creating new object.

* This violation is handled by using the method synchronized but it is not recommended as it takes extra overhead to perform.
*
* TO overcome this overhead make a Double-Checked Locking
*


*
* /
 */