package com.hhxy.dome;

import java.util.Scanner;

public class Dome07 {
    public static void main(String[] args) {
        //给定两个数字求其的商和余数,条件不可以使用/,%,*运算符
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数:");
        int number1 = sc.nextInt();
        System.out.println("请输入除数:");
        int number2 = sc.nextInt();
        //定义商
        int a = 0;
        //由于不知道次数用while
        while (number1 >= number2){
            number1 = number1-number2;
            a++;
        }
        System.out.println("商是:"+a);
        System.out.println("余数是:"+number1);


    }
}
