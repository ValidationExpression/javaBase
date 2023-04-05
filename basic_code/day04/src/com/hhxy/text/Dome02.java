package com.hhxy.text;

import java.util.Scanner;

public class Dome02 {
    /**
     * 判断一个数是否是一个质数(对于较小的数可以,但数字过大时不太适用)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int number = sc.nextInt();
        //定义一个布尔类型的值用于判断是否是质数(开始不是质数)
        boolean b = false;
        //质数的条件是:除了1和本身不能被其他数整除
        for (int i = 2; i<number;i++){
            //条件判断
            if(number%i == 0){
                b = true;
                break;
            }
        }
        //对定义的布尔值进行判断
        if(b){
            System.out.println("不是");
        }else {
            System.out.println("是");
        }

        /**
         * 优化算法
         * 思想:
         * 条件:2~1000000
         * 计算其最大数的平方根,原因一个数最大是由两个平方根相乘可以的出,
         * 列如:
         * 100 = 10*10
         * 10.1*10.1 > 100
         * 9.9*9.9 < 100
         * 所以只需要求出其平方根中是否是质数.
         *
         */
    }
}
