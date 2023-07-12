package com.hhxy.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {

        File f1=new File("D:\\ITData\\idea_data\\basic_code\\day26_io\\6.jpg");
        File f2=new File("D:\\ITData\\idea_data\\basic_code\\day26_io\\26.jpg");

        //使用的是commons-io.jar架包中的方法
        FileUtils.copyFile(f1,f2);
    }
}
