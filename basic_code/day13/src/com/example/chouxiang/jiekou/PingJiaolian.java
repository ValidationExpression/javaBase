package com.example.chouxiang.jiekou;

public class PingJiaolian extends jiaolian implements speaking{
    public PingJiaolian() {
    }

    public PingJiaolian(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("说英语");

    }
}
