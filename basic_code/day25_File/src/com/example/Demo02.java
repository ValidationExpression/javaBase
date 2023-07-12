package com.example;

import java.io.File;

/**
 * 需求:
 * 定义一个方法,用于查找某一个文件夹中(不考虑子文件),是否有avi后缀的电影.
 */
public class Demo02 {
    public static void main(String[] args) {
        File file=new File("D:\\3D相册");
        //调用方法
        System.out.println(haveAVI(file));

    }

    //定义一个方法
    public static boolean haveAVI(File file){
        //一个文件夹可能有多个文件,所以进行将其放入到一个数组中,进行遍历
        File[] files = file.listFiles();
        //增强for遍历
        for (File file1 : files) {
            //获取文件夹中文件的名字的后缀是否以.avi结尾,判断是否为文件
            if (file1.isFile() && file1.getName().endsWith(".avi")){
                return true;
            }
        }
        return false;
    }
}
