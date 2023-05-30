package com.example.duotai;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    ///自定义方法
    public void keepPet(Dog dog,String something){
        System.out.println("年龄:"+getAge()+"的"+getName()+"养"+dog.getColor()+"狗"+dog.getAge()+"岁");
        dog.eat(something);
    }
    public void keepPet(Cat cat,String something){
        System.out.println("年龄:"+getAge()+"的"+getName()+"养"+cat.getColor()+"猫"+cat.getAge()+"岁");
        cat.eat(something);
    }
    //使用多态
    //一个方法接收所有动物,猫,狗
    //定义这个属性可以不用对相同的方法进行多次重写
//    public void keepPet(Animal animal,String something){
//        System.out.println("年龄:"+getAge()+"的"+getName()+"养"+animal.getColor()+"猫"+animal.getAge()+"岁");
//        animal.eat(something);
//    }
//    public void keepPet(Animal animal, String something) {
//        //强制类型转换(含义instanceof判断后进行强行转换)
//        if (animal instanceof Dog d) {
//            System.out.println("年龄:" + getAge() + "的" + getName() + "养" + d.getColor() + "狗" +d.getAge() + "岁");
//            d.eat(something);
//        }else if (animal instanceof Cat c){
//            System.out.println("年龄:"+getAge()+"的"+getName()+"养"+c.getColor()+"猫"+c.getAge()+"岁");
//            c.eat(something);
//        }else {
//            System.out.println("misyo");
//        }
//    }
    public void keepPet(Animal animal, String something) {
        if (animal instanceof Dog) {
            keepDog((Dog) animal,something);
        } else if (animal instanceof Cat) {
            keepCat((Cat) animal,something);
        } else {
            System.out.println("Unknown animal type");
        }
    }

    private void keepDog(Dog dog,String something) {
        System.out.println("年龄：" + getAge() + "的" + getName() + "养" + dog.getColor() + "狗" + dog.getAge() + "岁");
        dog.eat(something);
    }

    private void keepCat(Cat cat,String something) {
        System.out.println("年龄：" + getAge() + "的" + getName() + "养" + cat.getColor() + "猫" + cat.getAge() + "岁");
        cat.eat(something);
    }
}
