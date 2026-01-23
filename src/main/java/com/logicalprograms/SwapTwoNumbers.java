package com.logicalprograms;

public class SwapTwoNumbers {

    public static void swapTwoNumbersUsingThirdVariable(){

        int a = 10;
        int b = 20;

        // o/p -> a = 20 & b = 10

        int temp;

        temp = a;
        a = b;
        b = temp;
        System.out.println("a: "+ a + " b: "+ b );

    }

    public static void swapTwoNumbersWithoutUsingThirdVariable(){
        int a = 10;
        int b = 20;

        a = a + b; // 30
        b = a - b; // 20
        a = a - b; // 10

        System.out.println("a: "+ a + " b: "+ b );

    }

    public static void main(String[] args) {
        swapTwoNumbersUsingThirdVariable();
        swapTwoNumbersWithoutUsingThirdVariable();
    }
}
