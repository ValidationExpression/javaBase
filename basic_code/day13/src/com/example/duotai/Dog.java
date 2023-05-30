package com.example.duotai;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }
    //重写父类eat
    @Override
    public void eat(String something) {
        System.out.println(getAge()+"狗"+getColor()+"色"+"吃"+something);
    }

    public void lookHome(){
        System.out.println("狗看家");
    }
}
