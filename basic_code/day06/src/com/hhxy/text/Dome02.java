package com.hhxy.text;

public class Dome02 {
    /**
     * 判断101-200之间有多少个质数
     * 质数:除本身和1不能被其他数整除
     */
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i < 201; i++) {
            //定义一个布尔值,此时的i是质数
            boolean f = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    //此时得出i不是质数,将f变为false
                    f = false;
                    //只要有一个被除尽,就要停止循环
                    break;
                }
            }
            //外层判断是否是
            if (f){
                count ++;
                System.out.println(i);
            }
        }
        System.out.println("个数"+count);
    }
}
