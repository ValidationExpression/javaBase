package com.example.stringText;

import java.util.Random;
import java.util.Scanner;

/**
 * 需求
 * 输入一个字符串,后进行打乱操作
 */
public class Text01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();
        System.out.println(dislocate(str));


    }

    //定义一个方法用于字符串打乱
    public static String dislocate(String str) {
        char[] c = str.toCharArray();
        Random r = new Random();
        //产生一个随机索引,进行交换
        char str1;
        for (int i = 0; i < c.length; i++) {
            int index1 = r.nextInt(c.length);
            if (i!=index1){
                //注意应当先存储需要交换的变量的值,因为赋值会进行覆盖原来的值,为了保证元数据不发生改变.
                str1=c[i];
                c[i]=c[index1];
                c[index1]=str1;
            }
        }
        return new String(c);
    }
}
