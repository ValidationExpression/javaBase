package com.hhxy.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 文件的拷贝A->
         * A: D:\3D相册\1636013177628.jpg
         * B: D:\ITData\idea_data\basic_code\day26_io\文件名可以自定义.jpg
         * FileInputStream : 读取文件
         * FileOutputStream :写入文件
         */

        /**
         * 可能会出现两个小错误
         * 1. 写入路径写出全部路径,和文件名
         */
        //读取文件
        FileInputStream fis = new FileInputStream("D:\\3D相册\\1636013177628.jpg");
        //写入文件
        FileOutputStream fos =new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\16.jpg");
        //拷贝
        int b;
        while ((b= fis.read()) != -1){ //当数据读完的时候,会返回-1
            //将数据写入
            fos.write(b);
        }
        //关闭数据流-先开的最后关
        fos.close();
        fis.close();
    }
}
