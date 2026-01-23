package com.java8basics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class MediumPrograms2 {

    private static List<Student> studentList = Arrays.asList(
            new Student("Aanna", 1, 70.0),
            new Student("Aappa", 2, 60.0),
            new Student("Birju", 3, 77.0),
            new Student("Birbal", 4, 95.0),
            new Student("Channa", 5, 40.00)

    );


    public static void sortByPercentage(){
        System.out.println(studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).collect(Collectors.toList()));
    }

    public static void findTheMaxPercentage(){
        // 70 > names
        // max per
        List<String> list = studentList.stream().filter(student -> student.getPercentage() > 70).map(Student::getName).toList();

        System.out.println(studentList.stream().mapToDouble(Student::getPercentage).max().orElse(0.0));

        System.out.println(studentList.stream().mapToDouble(Student::getPercentage).average().orElse(0.0));

        System.out.println(list);
    }

    public static void findTheResultOfStudent(){
       Map<Result, List<String>> map = studentList.stream().collect(Collectors.groupingBy(student -> getResult(student.getPercentage()),
                    Collectors.mapping(Student::getName, Collectors.toList())

                ));

        System.out.println(map);
    }

    private static Result getResult(Double percentage){
            if(percentage <= 40)
                return Result.FAIL;
            if(percentage >= 41 && percentage <= 74)
                return Result.PASS;
            else
                return Result.DISTINCTION;
    }

    public static void findTheStudent(){

       Map<Character, Long> characterCountMap = studentList.stream()
               .collect(Collectors.groupingBy(student -> student.getName().charAt(0), Collectors.counting()));

       System.out.println(characterCountMap);

       characterCountMap.entrySet().stream().max(

               Map.Entry.<Character, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey())

       ).stream().forEach(System.out::println);

       characterCountMap.values().stream().max(Comparator.comparingLong(Long::longValue)).stream().forEach(System.out::println);

        List<Long> longs = characterCountMap.values().stream().toList();

        longs.stream().mapToLong(v -> (Long)v).average();

        Double v = longs.stream().collect(Collectors.averagingLong(Long::longValue));

    }

    public static void main(String[] args) {
        findTheStudent();
        findTheResultOfStudent();
        findTheMaxPercentage();
        sortByPercentage();
    }
}


 enum Result{
    PASS, FAIL, DISTINCTION
}



/*
*
* list of students whose name start with 'a'.
*
* count the students.
*
* passed in 3 subject.
*
*  [1, 3 , 4, 5 , 6 , 7 , 8]
* [1, 3, 4] -> 8
* [3, 4, 5] -> sum
* [4, 5, 6] -> sum
* [5, 6, 7] -> sum
* [6, 7, 8] -> sum
*
* str = "i am Indian, you are a Indian #45t45";
*
* [i, am ] -> "i am"
* [am, Indian] -> "am Indian"
* [Indian, you] -> "Indian you"
*
* */


@Data
@AllArgsConstructor
@ToString
class Student{
    private String name;
    private int rollNumber;
    private Double percentage;
}