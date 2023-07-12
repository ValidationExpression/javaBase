package com.hhxy.example;

import java.io.*;

public class UtfToGbkDemo {
    public static void main(String[] args) throws IOException {
        /**
         * GDK文件转换为UTF-8类型的文件
         */
        //java8和java11不同
        InputStreamReader isr =
                new InputStreamReader(new FileInputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\c.txt"),"GBK");
        OutputStreamWriter osw =
                new OutputStreamWriter(new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\d.txt"),"UTF-8");

        int b;
        while ((b = isr.read())!=-1){
            osw.write(b);
        }
        osw.close();
        isr.close();
    }
}
