package com.hhxy.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 文件拷贝: 文件夹中含有子文件夹和子文件
         */
        //1.创建文件对象(起始路径)
        File aaa = new File("D:\\aaa\\408");
        //2.目标位置
        File bbb=new File("D:\\aaa\\409");

        //创建方法
        copyFile(aaa,bbb);
    }

    /**
     * @param aaa
     * @param bbb
     * 由于含有子文件夹,所以这里考虑使用递归遍历
     */
    public static void copyFile(File aaa, File bbb) throws IOException {
        //创建文件夹,不用进行判断
        bbb.mkdir();
        //1.将文件路径放到一个数组中
        File[] files = aaa.listFiles();
        //2.遍历数组
        for (File file : files) {
            //3.判断是文件还是文件夹
            if (file.isFile()){
                //进行文件拷贝流程,使用FileInputStream
                FileInputStream fis = new FileInputStream(file);
                //拷贝的文件地址(注意这里的路径,bbb这里是文件夹的路径,但是需要的是文件的路径)
                                                            //File(父级路径,子路径)
                FileOutputStream fos = new FileOutputStream(new File(bbb,file.getName()));
                //拷贝
                int len;
                //使用字节数组进行
                byte[] b=new byte[1024*1024*1];
                while ((len = fis.read())!=-1){
                    fos.write(b,0,len);
                }
                //关闭连接
                fos.close();
                fis.close();
            }else {
                //4.文件夹则使用递归
                //
                copyFile(file,new File(bbb,file.getName()));
            }
        }
    }
}
