package com.design_patterns.creational.builder;

public class BuilderExample {

    public static void main(String[] args) {

        Burger burger1 = Burger.builder().needToppings(false).size(1).burgertype(BURGERTYPE.VEG).build();

        Burger burger = new Burger.Builder("MAC", BURGERTYPE.VEG).build();
    }
}

