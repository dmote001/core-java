package com.design_patterns.creational.singletone;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonViolation {

    public static void main(String[] args) throws Exception{
        //Violation - 1 :
        Constructor<AppConfig> c = AppConfig.class.getDeclaredConstructor();
        c.setAccessible(true); // breaks the private rule
        AppConfig obj1 = c.newInstance();
        AppConfig obj2 = c.newInstance();
        System.out.println(obj1 == obj2); // false


        //Violation - 2 :
        AppConfig c1 = AppConfig.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a.obj"));
        out.writeObject(c1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("a.obj"));
        AppConfig c2 = (AppConfig) in.readObject();
    }
}

class AppConfig implements Serializable{
    private static final long serialVersionUID = 1L;
    private static AppConfig instance = new AppConfig();
    private AppConfig() {
        //Avoid violation 1
        if (instance != null) {
            throw new RuntimeException("Object already created");
        }
    }

    public static AppConfig getInstance() {
        return instance;
    }

    //Avoid violation 2
    private Object readResolve() {
        return instance;
    }
}