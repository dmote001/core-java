package com.gc.models;

public class UnreferenceObject {

    public static void main(String[] args) {
        Reference reference = new Reference();
        reference = null;
        // defining null to assigned object, this leads break connection
        // between reference variable and actual object.
        // Reference object is eligible to gc.
    }
}

