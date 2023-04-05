package com.hhxy.text;

import java.util.Random;
import java.util.Scanner;

public class Dome03 {
    /**
     * 猜数字
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //随机产生数字
        Random r = new Random();
        //可以设置范围,含左不含右
        //int result = r.nextInt(100);此时产生0~99之间的数字.
        //int result = r.nextInt(100)+1;此时产生1~100之间的数字.
        int result = r.nextInt(100);
        System.out.println(result);
        //因为需要多次判断所以使用循环
        //定义保底最大次数
        int count= 0;
        while (true){
            System.out.println("请输入数字:");
            int number = sc.nextInt();
            count++;
            /**
             * 可以实现保底机制
             */
            if (count == 5){
                System.out.println("回答正确");
                break;
            }
            if (number > result){
                System.out.println("数字大了");
            } else if (number < result) {
                System.out.println("数字小了");
            }else {
                System.out.println("回答正确");
                //因为定义的循环是true,会一直进行,所以当输入对时跳出循环
                break;
            }
        }
    }
}
