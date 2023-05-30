package com.example.chouxiang.jiekou;

public abstract class jiaolian extends Person{
    public jiaolian() {
    }

    public jiaolian(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
