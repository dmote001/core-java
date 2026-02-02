package com.design_patterns.creational.singletone;

public class EagerSingletone {
    private static EagerSingletone instance = new EagerSingletone();
    private EagerSingletone(){}

    public static EagerSingletone getInstance() {
        return instance;
    }
}

class EagerMain{
    public static void main(String[] args) {
        EagerSingletone eagerSingletone = EagerSingletone.getInstance();
        EagerSingletone eagerSingletone1 = EagerSingletone.getInstance();

        System.out.println(eagerSingletone == eagerSingletone1);

    }
}