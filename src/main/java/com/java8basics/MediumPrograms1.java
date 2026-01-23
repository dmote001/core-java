package com.java8basics;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MediumPrograms1 {

    public static void main(String[] args) {

    Predicate<Integer> isEven = (i) -> i % 2 == 0;

    Function<Integer, Integer> square = i -> i * i;
    Function<Integer, String> toString = i -> i + " -- " + String.valueOf(i);

    Consumer<String> consumer = s -> System.out.println(s);
    consumer.accept("Roshan");

    Supplier<Integer> supplier = () -> 1000;
    System.out.println(supplier.get());


        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.forEach(i -> System.out.println(i));

        list.stream().filter(isEven).map(i -> i * i).forEach(System.out::println);

    }
}



