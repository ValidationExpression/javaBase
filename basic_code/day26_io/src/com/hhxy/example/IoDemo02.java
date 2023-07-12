package com.hhxy.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo02 {
    public static void main(String[] args) throws IOException {
        /**
         * FileInputOutStream :是以字节的形式进行传输的,对于大文件的传输较慢
         * 为了加快速度是以byte []字节数组的形式进行传输
         */

        //读取文件
        FileInputStream fis = new FileInputStream("D:\\3D相册\\1636013177628.jpg");
        //写入文件
        FileOutputStream fos =new FileOutputStream("D:\\ITData\\idea_data\\basic_code\\day26_io\\6.jpg");
        //拷贝
        int len;
        //定义一个字节数组用于定义读取字节数量
        byte[] bt=new byte[1024*1024*1];  //1MB的速度进行读取(但是不能太大)
        while ((len = fis.read(bt)) != -1){
            //fos.write(bt);使用如下的方式限制长度的原因,由于自定义了读取字节的数量,
            // 所以可能在最后满足不了1MB的字节数,也就导致数组中还有部分上一次读取的数据,
            // 最后一次读取的数据只覆盖了前一段数据.  --所以使用长度进行限制,输入数量.
            fos.write(bt,0,len);
        }
        //关闭连接
        fos.close();
        fis.close();
    }
}
