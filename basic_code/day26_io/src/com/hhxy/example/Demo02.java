package com.hhxy.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos =new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\a.txt");

        fos.write(97);
        fos.close();
    }
}
