package com.example.chouxiang.jiekou;

public class Text {
    public static void main(String[] args) {
        PingSporter ps = new PingSporter("li",21);
        System.out.println(ps.getName()+":"+ps.getAge());
        ps.study();
        ps.speakEnglish();
    }
}
