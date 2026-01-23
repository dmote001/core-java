package com.logicalprograms;
public class BinarySearch {


    public static int binarySearch(int[] arr, int key, int start, int end){

        int mid = start + end / 2;

        if(key == arr[mid])
            return mid;
        else if (key < arr[mid]) {
            end = mid - 1;
        } else if (key > arr[mid]) {
            start = mid + 1;
        }

       return binarySearch(arr, key, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 10 , 11 };
        System.out.println(binarySearch( arr, 3, 0, arr.length - 1));
    }
}

/*
*
*
*  [10, 5, 3, 11, 4, 2]
*
* step 1: sort -> [ 2, 3, 4, 5, 10 , 11 ]
*
* start = 0;
* end = array length;
*
* step 2: searchValue = 5
*
*  midIndex =  array length / 2
*
* 1st scenario = if (array[midIndex] == searchValue) -> search index = midIndex
*
* 2nd scenario = searchValue = 3
*
* end = mid - 1;  // [ 2, 3, 4]
*
*
*
*
*
*
*
*
* */





