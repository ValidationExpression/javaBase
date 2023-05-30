package com.example.chouxiang.jiekou;

public class BasSporter extends Sporter{

    public BasSporter() {
    }

    public BasSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("打篮球");
    }
}
