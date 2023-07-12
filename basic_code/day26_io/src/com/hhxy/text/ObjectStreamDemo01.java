package com.hhxy.text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化流
 */
public class ObjectStreamDemo01 {
    public static void main(String[] args) throws IOException {

        //实例化student
        Student st =new Student("lisf",12);
        //序列化流
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\b.txt"));


        oos.writeObject(st);
        oos.close();
    }
}
