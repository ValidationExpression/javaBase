package com.example;

import java.io.File;
import java.io.IOException;

/**
 * 当前模块aaa文件夹下创建一个a.txt文件
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //1.创建a.txt父级路径
        File file=new File("day25_File\\aaa");
        //2.创建父级路径-这里不用if判断
        file.mkdirs();
        //拼接路径
        File src=new File(file,"a.txt");
        //判断是否创建成功
        boolean b=src.createNewFile();
        if (b){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }
    }
}
