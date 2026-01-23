package com.string.model;

import org.apache.logging.log4j.util.Strings;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.string.model.BasicPrograms.ReverseString.reverseString;
import static com.string.model.BasicPrograms.ReverseString.reverseStringJava8;

public class BasicPrograms {

     class ReverseString {
        public static void reverseString() {
            String s = "java programming";

            //option -1

            String reverseStr = "";

            for (int i = s.length() - 1; i >= 0; i--) {
                reverseStr = reverseStr + s.charAt(i);
            }

            System.out.println(reverseStr);

            // option -2
            String reverseStr2 = "";
            char[] chars = s.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                reverseStr2 = reverseStr2 + chars[i];
            }
            System.out.println(reverseStr2);

            // option - 3

            StringBuilder stringBuilder = new StringBuilder(s);
            System.out.println(stringBuilder.reverse());
        }

        public static void reverseStringJava8() {
            String s = "java programming";
            System.out.println(s.chars().mapToObj(c -> (char) c)
                    .reduce("", (a, b) -> b + a, String::concat));

        }

    }

    class CountCharsFrequency{

         public static void countCharFrequencyBasic(){
             String str = "java programming";
             Map<Character, Integer> charfrequencyMap = new HashMap<>();

             for(int i = 0; i <= str.length() - 1 ; i++){
                 charfrequencyMap.put(str.charAt(i), charfrequencyMap.getOrDefault(str.charAt(i), 0) + 1);
             }

             for(Map.Entry entry :charfrequencyMap.entrySet()){
                 System.out.println( entry.getKey() +" -- "+ entry.getValue());
             }

         }

        public static void countCharFrequencyBasicJava8(){
            String str = "java programming";

            str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                    c -> c, Collectors.counting()   // default hashmap
            )).forEach((key, value) -> System.out.println(key + " -- " + value));

        }
    }

    class FirstNonRepeatedCharacter{

         public static void firstNonRepeatedCharacter(){
             String str = "java programming";

             Map<Character, Integer> charCountMap = new LinkedHashMap<>(); // to maintain sequence.

             for(char ch : str.toCharArray()){
                 charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
             }

             for (Map.Entry<Character, Integer>  entry : charCountMap.entrySet()){
                 if(entry.getValue() == 1) {
                     System.out.println(entry.getKey());
                     break;
                 }
             }

         }

        public static void firstNonRepeatedCharacterJava8(){
            String str = "java programming";


            System.out.println(str.chars().mapToObj(c -> (char)c)
                    .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                            .map(Map.Entry::getKey)
                    .findFirst().get());

        }
    }

    class DuplicateCharacter{
         public static void removeDuplicateCharacter(){
             String str = "java programming";

             Set<Character> set = new LinkedHashSet<>();
             for (char c : str.toCharArray()){
                 set.add(c);
             }


             StringBuffer sb = new StringBuffer();

             for(char c : set){
                 sb.append(c);
             }

             System.out.println(sb);
         }

        public static void removeDuplicateCharacterJava8(){
            String str = "java programming";

            System.out.println(
                    str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()));
        }
    }

    class CountPunctuations{
         public static void countPunctuation(){
             String str = "He said, 'The mailman loves you.' I heard it with my own ears.";

             int count = 0;

             for(int i = 0 ; i<= str.length() -1 ; i++){
                 if(str.charAt(i) == '!' || str.charAt(i) == ',' || str.charAt(i) == ';'
                         || str.charAt(i) == '.' ||  str.charAt(i) == '?' || str.charAt(i) == '-'
                         || str.charAt(i) == '\'' || str.charAt(i) == '\"' || str.charAt(i) == ':'){
                     count++;
                 }
             }
             System.out.println(count);
         }

        public static void countPunctuationJava8(){
             List<Character> punctuations = Arrays.asList('!', ',', ':', '.', '?', '-', '\'', '\"', ':');
            String str = "He said, 'The mailman loves you.' I heard it with my own ears.";

            System.out.println(str.chars().mapToObj(ch -> (char) ch).filter(punctuations::contains).count());
        }
    }

    public class CountVowels{

         public static void countVowels(){
             String str = "He said, 'The mailman loves you.' I heard it with my own ears.".toLowerCase();

             int vowelCount = 0; int consonantCount = 0;

             for(int i = 0 ; i <= str.length()-1 ; i++){
                 if(str.charAt(i) == 'a' || str.charAt(i) == 'e'|| str.charAt(i) == 'i'|| str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                     vowelCount++;
                 }
                 else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                     consonantCount++;
                 }
             }
             System.out.println(vowelCount +" "+consonantCount);
         }


        public static void countVowelsJava8(){
            String str = "He said, 'The mailman loves you.' I heard it with my own ears.".toLowerCase();
            List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

            Predicate<Character> isCharacter = (c) -> c >= 'a' && c <= 'z';
            Predicate<Character> isVowel = vowels::contains;

            Map<Boolean, Long> countMap = str.chars().mapToObj(c -> (char) c)
                    .filter(isCharacter)
                    .collect(
                            Collectors.partitioningBy(isVowel, Collectors.counting())
                    );

            System.out.println(countMap.get(true) + " " + countMap.get(false));

        }
    }

    public class AnagramString{

         public static void anagramString(){

             String str1 = "abcd";
             String str2 = "dcba";

             if(str1.length() != str2.length()){

                 System.out.println("not anagram");

             }else {

                 char[] arr1 = str1.toCharArray();
                 char[] arr2 = str2.toCharArray();

                 Arrays.sort(arr1); // abcd
                 Arrays.sort(arr2); // abcd

                 System.out.println(arr1);
                 System.out.println(arr2);
                 if(Arrays.equals(arr1, arr2)){
                     System.out.println("anagram");
                 }
                 else {
                     System.out.println("not anagram");
                 }

             }
         }

        public static void anagramStringJava8_1(){
            String str1 = "abcd";
            String str2 = "dcba";


            String sortedStr1 = str1.chars().mapToObj(c-> String.valueOf((char)c)).sorted().collect(Collectors.joining());
            String sortedStr2 = str2.chars().mapToObj(c-> String.valueOf((char)c)).sorted().collect(Collectors.joining());

            System.out.println("Strings are anagram ? - " + sortedStr1.equals(sortedStr2));
        }

        public static void anagramStringJava8_2(String str1, String str2){
//            String str1 = "abcd";
//            String str2 = "dcba";

            boolean isAnagram = str1.length() == str2.length() &&
                    str1.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                    .equals(
                            str2.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting())));

            System.out.println("Strings are anagram ? - " + isAnagram);
        }
    }

    public class DivideString{

         public static void divideStringIntoNparts(){
             String  str = "aaaa bbbb cccc dddd"; //16 / 4 -> 4
             int n = 4;
             List<String> list = new ArrayList<>();

             if(Strings.isNotBlank(str) && str.length() % n == 0){

                 int subLength = str.length() / n;

                 for (int i = 0; i < str.length(); i = i + subLength){
                     list.add(str.substring(i, i + subLength)); // 0 -> 4 | 4 -> 8 | 8 -> 12 | 12 - 16
                 }
             }

             System.out.println(list);
         }

         public static void regexSolution(){
             String  str = "aaaabbbbccccdddd";
             int n = 4;
             if(Strings.isNotBlank(str) && str.length() % n == 0){
                 List<String> list = Arrays.asList( str.split("(?<=\\G.{" + (str.length() / n) + "})") );
                 System.out.println(list);
             }
         }

        public static void divideStringIntoNpartsJava8(){
            String  str = "aaaabbbbccccdddd";
            int n = 4;

            if(Strings.isNotBlank(str) && str.length() % n == 0){
                IntStream.range(0, n).mapToObj(i ->
                        str.substring(i * str.length() / n, (i + 1) * str.length() / n))
                        .collect(Collectors.toList()).forEach(System.out::println);
            }
            /*
            * | i | start    | end      | substring |
            | - | -------- | -------- | --------- |
            | 0 | 0×4 = 0  | 1×4 = 4  | `"aaaa"`  |
            | 1 | 1×4 = 4  | 2×4 = 8  | `"bbbb"`  |
            | 2 | 2×4 = 8  | 3×4 = 12 | `"cccc"`  |
            | 3 | 3×4 = 12 | 4×4 = 16 | `"dddd"`  |
            */
        }
    }


    public static void main(String[] args) {
//        reverseString();
//        reverseStringJava8();
//        CountCharsFrequency.countCharFrequencyBasic();
//        CountCharsFrequency.countCharFrequencyBasicJava8();
        FirstNonRepeatedCharacter.firstNonRepeatedCharacter();
        FirstNonRepeatedCharacter.firstNonRepeatedCharacterJava8();
        DuplicateCharacter.removeDuplicateCharacter();
        DuplicateCharacter.removeDuplicateCharacterJava8();
        CountPunctuations.countPunctuation();
        CountPunctuations.countPunctuationJava8();
        CountVowels.countVowelsJava8();
        AnagramString.anagramString();
        AnagramString.anagramStringJava8_1();
        DivideString.divideStringIntoNparts();
        DivideString.regexSolution();
    }
}
