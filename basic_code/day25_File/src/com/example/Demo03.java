package com.example;

import java.io.File;

/**
 * 需求:
 * 遍历D://  的所有文件,找到其中以.mp4文件后缀的文件,
 * 并进行输出.
 *
 * 实现方法: 递归(原因不清楚不同文件夹中的文件类型和数量)
 */
public class Demo03 {
    public static void main(String[] args) {
        //File file=new File("D:\\");
        //fileMP4(file);
        fileMP4();

    }
    public static void fileMP4(){
        //获取本地所有盘符
        File[] files = File.listRoots();
        //遍历
        for (File file : files) {
            fileMP4(file);
        }

    }
    //定义一个方法单个盘符
    public static void fileMP4(File file){
        //1.找到D盘下的所有文件或文件夹
        File[] files = file.listFiles();
        //在不同的目录可能会存在权限问题,因此在这里进行判断
        if (files != null) {
            //2.增强for遍历
            for (File file1 : files) {
                //3.判断文件是文件夹还是文件
                if (file1.isFile()){
                    //在判断是否是以.mp4结尾的文件
                    if (file1.getName().endsWith(".mp4")){
                        System.out.println(file1);
                    }
                }else {
                    //4.如果是文件夹则进行递归遍历
                    fileMP4(file1);
                }
            }
        }
    }
}
