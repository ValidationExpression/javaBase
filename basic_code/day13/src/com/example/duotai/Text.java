package com.example.duotai;

public class Text {
    public static void main(String[] args) {
        Person person = new Person("lihua",31);
        //调用方法
        Dog dog = new Dog(2,"白");
        person.keepPet(dog,"骨头");

        //多态调用
        Person person1 = new Person("lihua",31);
        Animal animal = new Dog(2,"白");
        person1.keepPet(animal,"骨头");
        person1.keepPet(animal,"🐟");
    }
}
