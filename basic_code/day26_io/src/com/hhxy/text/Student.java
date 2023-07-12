package com.hhxy.text;

import java.io.Serializable;

/**
 * Serializable:是一个无方法的接口,用于作为序列化流额一个标记
 */
public class Student implements Serializable {

    //设置版本号(当修改javabean文件的时候,如果不设置版本号,此时运行序列化时会报错)
    private static final long serialVersionUID=1L;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
