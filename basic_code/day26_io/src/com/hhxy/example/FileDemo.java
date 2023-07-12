package com.hhxy.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 对文件进行加密处理
         * 使用  ^: 异或操作(相同为0,不同为1)
         * 原理   : A ^ B = C
         * 还原   : C ^ B = A
         */
        //读取文件
       // FileInputStream fis = new FileInputStream("D:\\3D相册\\1636013177628.jpg");
        //写入文件
        //FileOutputStream fos =new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\6.jpg");
        /**
         * 解密
         */
        FileInputStream fis = new FileInputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\6.jpg");
        //写入文件
        FileOutputStream fos =new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\16.jpg");
        //拷贝
        int b;
        while ((b= fis.read()) != -1){ //当数据读完的时候,会返回-1
            //将数据写入(只有单个字节可以使用)
            fos.write(b ^ 10);
        }
        //关闭连接
        fos.close();
        fis.close();
    }
}
