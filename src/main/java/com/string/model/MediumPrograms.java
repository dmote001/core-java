package com.string.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MediumPrograms {
    static BiPredicate<String, String> isPalindrom = String::equals;

    class StringPalindrom {
        public static void stringPalindromMethod2(){
            String originalString = "roshan";
            String reversString = "";

            for(int i = originalString.length() - 1 ; i>= 0 ; i--){
                reversString = reversString +  originalString.charAt(i);
            }

            if(originalString.equals(reversString)){
                System.out.println(originalString + " is palindrom");
            }
            else {
                System.out.println(originalString + " is not palindrom");
            }
        }

        public static void stringPalindromMethod1(){

            // original == reverse

            String originalString = "abba";
            String reversString = "";

            char[] chars = originalString.toCharArray();

            for( int i = chars.length -1 ; i >= 0 ; i--){
                reversString += chars[i];
            }

            if(originalString.equals(reversString)){
                System.out.println(originalString + " is palindrom");
            }
            else {
                System.out.println(originalString + " is not palindrom");
            }
        }

        public static void stringReverseUsingStrinBuilder(){
            String originalString = "abba";

            System.out.println(
                    isPalindrom.test(originalString, new StringBuilder(originalString).reverse().toString())
            );
        }

        public static void stringPalindrom8_1(){
            String originalString = "roshan";
            String reversString = "";

            BiPredicate<String, String> isPalindrom = String::equals;

            reversString = originalString.chars().mapToObj(c -> (char)c)
                    .collect(Collectors.toList()).reversed().stream()
                    .map(character -> String.valueOf(character))
                    .collect(Collectors.joining());

            System.out.println(isPalindrom.test(originalString, reversString));

        }

        public static void stringPalindrom8_2(){
            String originalString = "ab ba";

            String reversString = originalString.chars()
                    .mapToObj(c -> String.valueOf((char)c))
                    .reduce("", (a,b) -> b + a);

            System.out.println(isPalindrom.test(originalString, reversString));
        }

        public static void stringPalindrom8_3(){
            String originalString = "ababa";

            boolean isPalindrom = IntStream.range(0, originalString.length() / 2)
                    .allMatch(i -> originalString.charAt(i) == originalString.charAt(originalString.length() - 1 - i));

            System.out.println(isPalindrom);
        }


    }

    public static void main(String[] args) {
        StringPalindrom.stringPalindromMethod2();
        StringPalindrom.stringPalindrom8_3();
    }
}
