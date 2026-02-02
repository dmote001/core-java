package com.design_patterns.creational.singletone;

public class StaticInnerClass {

    private StaticInnerClass() {
        System.out.println("Instance created");
    }

    private static class SingletonInner{

        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }
    public static StaticInnerClass getInstance()
    {
        return SingletonInner.INSTANCE;
    }
}

class StaticInnerClassMain{

    public static void main(String[] args) {
        StaticInnerClass instance = StaticInnerClass.getInstance();
        StaticInnerClass instance2 = StaticInnerClass.getInstance();
        System.out.println(instance = instance2); // true
    }
}
/**
 *
 * A class is loaded into memory only once by the JVM.
 * An inner class is loaded only when it is referenced.
 * Therefore, the Singleton instance is created lazily, only when the getInstance() method accesses the inner class.
 */
