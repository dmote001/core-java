package com.gc.models;

public class ObjectInsideMethod {

    public static void getReferenceObject(){
      Reference reference =   new Reference();
    }

    public static void main(String[] args) {
        getReferenceObject();
        /*
        * The object created in side the method is reffering to the local reference.
        * once the method execution finished
        * i.e. method call stack poped the method frame then there will be no evidence of object reference
        * so the reference object is eligible to gc
        *
        * */
    }
}
