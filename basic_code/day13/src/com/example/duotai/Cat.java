package com.example.duotai;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge()+"猫"+getColor()+"色"+"吃"+something);
    }

    public void catchMouth(){
        System.out.println("猫捉老鼠");

    }
}
