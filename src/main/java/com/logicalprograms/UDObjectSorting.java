package com.logicalprograms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UDObjectSorting {

    public static void sortStudents(){

        Student student = new Student("aa", 1);
        Student student1 = new Student("bb", 2);
        Student student2 = new Student("cc", 3);
        Student student3 = new Student("aa", 4);

        List<Student> studentList = Arrays.asList(student, student1, student2, student3);

        List<Student> studentList1 = (List<Student>) Collections.unmodifiableCollection(studentList);

        studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getId).reversed()).forEach(System.out::println);
          studentList.stream().sorted((a,b) -> b.getName().compareTo(a.getName())).forEach(System.out::println);

        studentList.stream().sorted((a,b) -> b.getId() - a.getId()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        sortStudents();
    }

}
/*
@Data
@AllArgsConstructor
@ToString
class Student implements Comparable<Student>{
    private String name;
    private int id;

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}

comparable -> compareTo(Object o) -> single sequence of type or natural ordering
comparator -> comparing(Object o1, Object o2) -> multi sequence for user defined objects
*/


@Data
@AllArgsConstructor
@ToString
class Student{
    private String name;
    private int id;

}