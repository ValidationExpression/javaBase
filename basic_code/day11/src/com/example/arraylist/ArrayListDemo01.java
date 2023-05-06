package com.example.arraylist;

import java.util.ArrayList;

/**
 * 需求:
 * 定义一个集合,添加学生属性,并遍历学生类,属性姓名,年龄
 */
public class ArrayListDemo01 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //实例化
        Student s1 = new Student("1",12);
        Student s2 = new Student("2",12);
        Student s3 = new Student("3",12);
        //添加数据
        list.add(s1);
        list.add(s2);
        list.add(s3);
        
        //查看
        for (int i = 0; i < list.size(); i++) {
            //建立集合索引
            Student index = list.get(i);
            //使用set,get方法获取值
            System.out.println(index.getName()+","+index.getAge());
        }
    }
    
}
