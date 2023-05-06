package com.example.stringText;

import java.util.ArrayList;
import java.util.Random;

/**
 * 需求:
 * 产生验证码
 * 內容:大小写字母和数字,四位字母一位数字(数字可以出现在任意位置)
 */
public class Text02 {
    public static void main(String[] args) {
        //随机产生索引
        Random r=new Random();
        //定义一个中间变量
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(52);
            str.append(randomString(index));
        }
        int number = r.nextInt(10);
        str.append(number);
        String strToString = str.toString();
        System.out.println(dislocate(strToString));
    }

    //使用数组随机索引
    public static char randomString(int index){
        char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','s','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','S','Y','Z'};

        //方式2,产生大小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i=0;i<26;i++){
            list.add((char) ('a'+i));
            list.add((char) ('A'+i));
        }

        //随机取出4个字符
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //随即索引
            int index1 = r.nextInt();
            char c1=list.get(index1);
            sb.append(c1);
        }
        return c[index];
    }

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
