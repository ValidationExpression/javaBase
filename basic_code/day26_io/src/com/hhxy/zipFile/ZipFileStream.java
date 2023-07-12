package com.hhxy.zipFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileStream {
    public static void main(String[] args) throws IOException {
        /**
         * 解压缩文件
         * 使用ZipInputStream
         *
         * 注意文件的编码格式问题,如果压缩文件的格式和idea中的不同,则会出现 java.lang.IllegalArgumentException: MALFORMED错误
         */
        //解压文件
        File f1 = new File("D:\\aaa\\a.zip");
        //目标文件
        File f2 = new File("D:\\aaa");
        zipFile(f1,f2);

    }

    //解压
    public static void zipFile(File f1, File f2) throws IOException {
        //本质就是将压缩包中的文件所有文件都读到另一个文件夹中
        ZipInputStream zis = new ZipInputStream(new FileInputStream(f1));
        //获取压缩包中的文件对象
        ZipEntry zipEntry;
        //使用循环遍历读出
        while ((zipEntry = zis.getNextEntry()) != null) {
            //此时需要判断要进行读得是文件还是文件夹
            if (zipEntry.isDirectory()) {
                //是文件夹,则进行创建(父级文件夹,子文件)
                File f3 = new File(f2, zipEntry.toString());
                f3.mkdirs();
            } else {
                //如果是文件,则使用FileOutputStream(需要指定绝对路径,所以需要new File)进行输出
                FileOutputStream fos = new FileOutputStream(new File(f2, zipEntry.toString()));
                int b;
                while ((b = zis.read()) != -1) {
                    fos.write(b);
                }
                //关闭fos
                fos.close();
                //关闭zis的对象
                zis.closeEntry();
            }
        }
        //关闭压缩流
        zis.close();
    }
}
