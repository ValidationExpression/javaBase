package com.hhxy.dome;

import java.util.Scanner;

public class Dome06 {
    public static void main(String[] args) {
        //判断是否是回文数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数:");
        int number = sc.nextInt();
        //定义一个临时变量,用于最后比较
        int temp = number;
        //记录倒过来的值
        int num = 0;
        //由于不知道次数所以用while循环
        while (number!=0){
            //得出个位的值
            int ge = number % 10;
            //得出出去个位后的数字
            number = number/10;
            //数字变换
            num = num*10 +ge;
        }
        if(num==temp){
            System.out.println("数字"+temp+"是回文数...");
        }
    }
}
