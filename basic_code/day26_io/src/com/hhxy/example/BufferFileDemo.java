package com.hhxy.example;

import java.io.*;

public class BufferFileDemo {
    public static void main(String[] args) throws IOException {

        //读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\aaa\\408\\治愈系.pptx"));
        //写入文件
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\aaa\\409\\治愈系.pptx"));
        //拷贝
        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        //关闭连接
        bos.close();
        bis.close();
    }
}
