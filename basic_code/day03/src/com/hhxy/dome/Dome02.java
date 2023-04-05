package com.hhxy.dome;

import java.util.Scanner;

public class Dome02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入票号:");
        int a = sc.nextInt();
        //判断票号是否合法
        if( a <= 100 & a>=0){
            if(a % 2 == 0){
                System.out.println("您的票在左边...");
            }else {
                System.out.println("您的票号在右边...");
            }
        }else {
            System.out.println("您的票有问题.");
        }

    }
}
