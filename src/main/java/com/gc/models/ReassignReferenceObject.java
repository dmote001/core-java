package com.gc.models;

public class ReassignReferenceObject {

    public static void main(String[] args) {
       Reference reference = new Reference(); // ref-obj-1
        reference = new Reference(); // ref-obj-2
        /*
        *  here, the ref-obj-1 was reffered to reference variable but
        * after assigning ref-obj-2 to the reference variable
        *
        * the connection between reference varibale and ref-obj-1 is broken and is eligible for gc.
        * */
    }
}
