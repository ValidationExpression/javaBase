package com.hhxy.text;

import java.util.Random;

public class Dome03 {
    /**
     * 需求:
     * 随机产生一个5位的验证码
     * 格式:前四位是大小写字母,最后一位是数字
     */
    public static void main(String[] args) {
        //定义数组用于存储大小写字母
        char[] ch = new char[52];
        for (int i = 0; i < ch.length; i++) {
            //利用ASCII表进行数字和字母的对应,前26位小写
            if (i < 26){
                //进行强制类型转换,前26位小写
                ch[i] = (char)(97+i);
            }else{
                //小写
                ch[i] = (char)(65 + i-26);
            }
        }
        //定义一个字符串用于存储验证码
        String result = "";

        //随机遍历
        Random ra = new Random();
        for (int i = 0; i < 4; i++) {
            int index = ra.nextInt(52);
            result = result+ch[index];
        }
        //数字随机
        int numberIndex = ra.nextInt(10);
        result =result+numberIndex;
        System.out.println("验证码是:"+result);
    }

}
