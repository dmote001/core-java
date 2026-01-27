package com.singletone;

public class EnumSingleton {
    private static EnumSingleton instance;
    private EnumSingleton()
    {
        System.out.println("Singleton is Instantiated.");
    }
    public static EnumSingleton getInstance()
    {
        if (instance == null)
            instance = new EnumSingleton();
        return instance;
    }
    public static void doSomething()
    {
        System.out.println("Something is Done.");
    }
}

enum EnumSingleton1 {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }
}