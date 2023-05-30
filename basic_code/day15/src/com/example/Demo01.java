package com.example;

import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //获取电脑线程数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //jvm总内存
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        //已经使用了多少内存(字节)
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        //
        Runtime.getRuntime().exec("shutdown -a");
    }
}
