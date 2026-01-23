package com.string.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModeratePrograms {

    class SubSet{

        public static void findPossibleSubsets(){

            String str = "banana";
            /*
            *  0 [b], [ba], [ban], [bana], [banan]
            *  1 [a], [an] [ana],.....
            *  2
            * 3
            * 4
            *
            * */


            int n = str.length();

            for (int i = 0 ; i < n; i++){
                for (int j = i; j<n; j++){
                    System.out.println(str.substring(i, j + 1));
                }
            }
        }

        public static void findPossibleSubsetsJava8() {

            String str = "banana"; // [f] [u] [n] [fu] [fn] [un]
            int n = str.length();

            IntStream.range(n, 0)
                    .forEach(i ->
                            IntStream.range(i,n).forEach(j -> {
                                System.out.println( i +" "+j);
                            })
                    );
        }



    }

    public class LongestRepeatingSequence {

        public static void longestRepeatingSequence() {
            String str = "banana";
            Map<String , Integer> mapOfSubstringCount = new HashMap<>();

            int n = str.length();
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    String sub = str.substring(i, j+1);
                    System.out.println(sub);
                    mapOfSubstringCount.put(sub, mapOfSubstringCount.getOrDefault(sub, 0) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
//        SubSet.findPossibleSubsets();
//        SubSet.findPossibleSubsetsJava8();
        LongestRepeatingSequence.longestRepeatingSequence();
    }
}
