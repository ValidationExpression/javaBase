package com.hhxy.example;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        /**
         * 四种方式拷贝文件
         * 1.字节基本流: 一次一个字节
         * 2.字节基本流: 一个读取一个数组
         * 3.字节缓冲流:一次一个字节
         * 4.字节缓冲流: 一个读取一个数组
         */

        //1.
        System.out.println("1: "+copyFile01());
        //2.
        System.out.println("2: "+copyFile02());
        //3.
        System.out.println("3: "+copyFile03());
        //4.
        System.out.println("4: "+copyFile04());
    }

    //1.字节基本流: 一次一个字节
    public static long copyFile01() throws IOException {
        long start = System.currentTimeMillis();
        //
        FileInputStream fis = new FileInputStream("D:\\aaa\\408\\治愈系.pptx");
        FileOutputStream fos =new FileOutputStream("D:\\aaa\\409\\治愈系.pptx");
        //拷贝
        int b;
        while ((b=fis.read()) != -1){
            fos.write(b);
        }
        //关闭连接
        fos.close();
        fis.close();
        long end= System.currentTimeMillis();
        return end-start;
    }

    //2.字节基本流: 一个读取一个数组
    public static long copyFile02() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\aaa\\408\\治愈系.pptx");
        FileOutputStream fos =new FileOutputStream("D:\\aaa\\409\\治愈系.pptx");
        //拷贝
        int len;
        byte[] bt =new byte[1024*1024*2];
        while ((len=fis.read(bt)) != -1){
            fos.write(bt,0,len);
        }
        //关闭连接
        fos.close();
        fis.close();
        long end= System.currentTimeMillis();
        return end-start;
    }
    //3.字节缓冲流:一次一个字节
    public static long copyFile03() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\aaa\\408\\治愈系.pptx"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\aaa\\409\\治愈系.pptx"));
        //拷贝
        int b;
        while ((b=bis.read()) != -1){
            bos.write(b);
        }
        //关闭连接
        bos.close();
        bis.close();
        long end= System.currentTimeMillis();
        return end-start;
    }
    //4.字节缓冲流: 一个读取一个数组
    public static long copyFile04() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\aaa\\408\\治愈系.pptx"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\aaa\\409\\治愈系.pptx"));
        //拷贝
        int len;
        byte[] bt =new byte[1024*1024*2];
        while ((len=bis.read(bt)) != -1){
            bos.write(bt,0,len);
        }
        //关闭连接
        bos.close();
        bis.close();
        long end= System.currentTimeMillis();
        return end-start;
    }

}
