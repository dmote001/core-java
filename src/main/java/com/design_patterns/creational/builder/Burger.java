package com.design_patterns.creational.builder;

public class Burger {
    private String brand;
    private int size;
    private BURGERTYPE burgertype;
    private boolean needToppings;
    private Builder builder;

    public Burger(Builder builder){
            this.brand = builder.brand;
            this.size = builder.size;
            this.burgertype = builder.burgertype;
            this.needToppings = builder.needToppings;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String brand;
        private int size;
        private BURGERTYPE burgertype;
        private boolean needToppings;

        public Builder(String brand, BURGERTYPE burgertype) {
            this.brand = brand;
            this.burgertype = burgertype;
        }

        public Builder() {

        }

        public Builder size(int size){
            this.size = size;
            return this;
        }

        public Builder burgertype(BURGERTYPE burgertype){
            this.burgertype = burgertype;
            return this;
        }

        public Builder needToppings(boolean needToppings){
            this.needToppings = needToppings;
            return this;
        }

        public Burger build(){
            return new Burger(this);
        }

    }
}

