package com.example.chouxiang.jiekou;

public class PingSporter extends Sporter implements speaking{

    public PingSporter() {
    }

    public PingSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("说英语");
    }
}
