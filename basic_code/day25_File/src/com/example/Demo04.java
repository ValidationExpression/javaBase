package com.example;

import java.io.File;

/**
 * 需求:
 * 删除文件夹中的內容
 *
 * 使用delete方法,注意它只能删除文件和空文件夹,
 */
public class Demo04 {
    public static void main(String[] args) {

        File file=new File("D:\\a\\a");
        deleteFile(file);

    }

    //删除的方法
    public static void deleteFile(File file){
        //1.找到D盘下的所有文件或文件夹
        File[] files = file.listFiles();
        //在不同的目录可能会存在权限问题,因此在这里进行判断
        if (files != null) {
            //2.增强for遍历
            for (File file1 : files) {
                //3.判断文件是文件夹还是文件
                if (file1.isFile()){
                    //进行删除
                    file1.delete();
                }else {
                    //4.如果是文件夹则进行递归遍历(此时为第二个方法)
                    deleteFile(file1);
                }
            }
        }
        file.delete();
    }
}
