package com.hhxy.dome01;

import java.util.Scanner;

public class Dome01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        int t = sc.nextInt();
        System.out.println("请输入第二个数字:");
        int t1 = sc.nextInt();
        int t2 = t+t1;
        boolean result = t == 6 || t1 ==6 || t2 % 6 == 0;
        System.out.println(result);
    }
}
