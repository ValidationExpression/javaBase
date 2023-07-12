package com;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int a= sc.nextInt();
        String s = a % 2 == 0 ? "偶数" : "奇数";
        System.out.println(s);

    }
}
