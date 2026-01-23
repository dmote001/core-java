package com.gc.models;

public class GCExternalHandling {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC cleaning up…");
    }

    public static void main(String[] args) {
        Reference reference = new Reference();
        reference = null;
        System.gc();
        Runtime.getRuntime().gc();
    }
}
