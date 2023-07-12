package com.hhxy;

import java.util.HashSet;

/**
 * 需求:
 * 创建一个存储学生的对象集合,存储多个学生对象,
 * 要求:学生对象的成员变量值相同,我们就认为是同一个对象
 */
public class HashSet_Demo01 {
    public static void main(String[] args) {

        HashSet<Student> list=new HashSet<>();
        list.add(new Student("liha",18));
        list.add(new Student("liha",18));
        list.add(new Student("lihaa",16));
        System.out.println(list);
    }
}
