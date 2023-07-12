package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 需求:
 * 创建一个HashMap集合,键为学生(Student)对象,值为籍贯(String)
 * 存储三个对象,并遍历
 * 要求:同姓名.同年龄为一个学生
 */
public class HashMap_Demo01 {
    public static void main(String[] args) {
        HashMap<Student,String> hh=new HashMap<>();

        //创建对象
        Student st1=new Student("lisf",12);
        Student st2=new Student("sfaf",22);
        Student st3=new Student("aff",16);

        //将对象放入集合
        hh.put(st1,"上海");
        hh.put(st2,"武汉");
        hh.put(st3,"北京");

        //遍历集合1.
        Set<Student> s=hh.keySet();
        for (Student key : s) {
            String value = hh.get(key);
            System.out.println(key+":"+value);
        }

        //方式2
        Set<Map.Entry<Student, String>> entries = hh.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);
        }

    }
}
