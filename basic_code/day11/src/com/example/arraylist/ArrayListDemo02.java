package com.example.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 需求:
 * 定义一个集合,
 * 自定义添加学生属性,并遍历学生类,属性姓名,年龄
 */
public class ArrayListDemo02 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);

        for (int i=0;i<3;i++) {
            //实例化学生类(一定要实例化每个学生的对象,不然会覆盖---这个只是地址值)
            Student stu = new Student();
            System.out.println("请输入姓名:");
            String name = sc.next();
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            stu.setName(name);
            stu.setAge(age);
            //添加数据
            list.add(stu);
        }

        //查看
        for (int i = 0; i < list.size(); i++) {
            //建立集合索引
            Student index = list.get(i);
            //使用set,get方法获取值
            System.out.println(index.getName()+","+index.getAge());
        }
    }
}
