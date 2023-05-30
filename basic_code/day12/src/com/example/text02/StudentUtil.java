package com.example.text02;

import java.util.ArrayList;

/**
 * 实现定义一个集合,存储三个学生对象,其中的属性name,age,gender,
 * 获取集合中最大学生的年龄
 */
public class StudentUtil {
    private StudentUtil(){}

    //
    public static int getMaxAge(ArrayList<Student> list){
        //定义一个参照物
        Student stu = list.get(0);
        int maxAge = stu.getAge();
        for (int i = 1; i < list.size(); i++) {
            stu = list.get(i);
            if (stu.getAge()>maxAge){
                maxAge= stu.getAge();
            }
        }
        return maxAge;
    }
}
