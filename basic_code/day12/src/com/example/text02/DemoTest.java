package com.example.text02;

import java.util.ArrayList;

public class DemoTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("李华",22,"男");
        Student stu2 = new Student("li",21,"女");
        Student stu3 = new Student("sdf",25,"男");
        //添加到数组
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        int max = StudentUtil.getMaxAge(list);
        System.out.println(max);
    }
}
