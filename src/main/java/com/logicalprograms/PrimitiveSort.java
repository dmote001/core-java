package com.logicalprograms;

import java.util.*;
import java.util.stream.Collectors;

public class PrimitiveSort {


    public static void primitiveSort(){
        int[] arr = {7, 5, 2, 1, 7};

        Arrays.sort(arr); // call by val or by ref ?

        for(int i =0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
        List<Integer> list = Arrays.stream(arr).mapToObj(i -> (Integer)i).collect(Collectors.toList());

        Collections.sort(list);

        Arrays.stream(arr).mapToObj(i -> (Integer)i).sorted().collect(Collectors.toList()).forEach(System.out::println);

        Arrays.stream(arr).mapToObj(i -> (Integer)i).sorted((a,b) -> b - a).collect(Collectors.toList()).forEach(System.out::println);

        Set<Integer> set = new TreeSet<>(list);

        set.stream().forEach(System.out::println);

    }

    public static void bubbleSort(){
        int[] arr = {7, 5, 2, 1, 7};
        int temp;
        boolean isSwaped;

        for (int i = 0 ; i< arr.length ; i++){  // 0..n
            isSwaped = false;
            for (int j = 0 ; j < arr.length - i - 1 ; j++){ // 0 ..
                if(arr[j] > arr[j + 1]){

                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    isSwaped = true;
                }
                if(isSwaped == false)
                    break;
            }
        }
        // sorted array
        for (int i = 0 ; i< arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(){
        int[] arr = {1, 7, 5, 2, 1, 8};
        int temp;

        for(int i = 0 ; i < arr.length - 1; i++){

            int smallindex = i;

            for (int j = i + 1; j < arr.length ; j++){
                if(arr[j] < arr[smallindex]){
                    smallindex = j;
                }
            }

            temp = arr[i] ;
            arr[i] = arr[smallindex];
            arr[smallindex] = temp;
        }

        // sorted array
        for (int i = 0 ; i< arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
//        primitiveSort();
//        bubbleSort();
        selectionSort();
    }
}

/*

int a, int b


temp = a;
a =b;
b= temp;

*  [7, 5, 2, 1]
*
* bubble sort
*
* itr 1 - [5, 7, 2, 1]
* itr 1 - [5, 2, 7, 1]
* itr 1 - [5, 2, 1, 7]
*

itr 2 - [5, 2, 1, [ 7]]
itr 2 - [2, 1, 5, [ 7]]
    [2, 1, [5,  7]]

itr 3 - [1, 2, [5,  7]]

[[1, 2, 5,  7]]

*
*
*
*  // selection sort

*
*
*
* */