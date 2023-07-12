package com.hhxy.text;

import java.io.*;
import java.util.ArrayList;

public class Demo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * 当创建多个对象的时候,一般会使用数组将对象进行存储
         */
        //序列化
        //outPut();
        //反序列化
        inPut();
    }

    //序列化输入
    public static void outPut() throws IOException {
        //实例化student
        Student st1 =new Student("lisf",12);
        Student st2 =new Student("lis",12);
        Student st3 =new Student("li",12);
        //序列化流
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\e.txt"));
        //创建一个数组
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        //将数组放入到序列流中
        oos.writeObject(arr);
        oos.close();
    }

    //反序列化
    public static void inPut() throws IOException, ClassNotFoundException {
        ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\e.txt"));

        //进行输入,并强转操作
        ArrayList<Student> list = (ArrayList<Student>)ois.readObject();
        //循环遍历输出
        for (Student student : list) {
            System.out.println(student);
        }
        ois.close();
    }
}
