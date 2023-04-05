package com.hhxy.dome;

import java.util.Scanner;

public class Dome05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int a = sc.nextInt();
        System.out.println("请输入第二个数:");
        int b = sc.nextInt();
        //定义次数的变量
        int d = 0;
        for(int c = a;c <= b;c++){
            if(c%5 == 0 & c%3 == 0){
                d++;
            }
        }
        System.out.println("在"+a+"到"+b+"范围,可以被3且5整除的数有:"+d);
    }
}
