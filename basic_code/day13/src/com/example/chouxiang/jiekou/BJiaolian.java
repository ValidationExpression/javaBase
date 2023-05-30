package com.example.chouxiang.jiekou;

public class BJiaolian extends jiaolian{
    public BJiaolian() {
    }

    public BJiaolian(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教篮球");
    }
}
