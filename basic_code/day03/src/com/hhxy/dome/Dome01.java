package com.hhxy.dome;

import java.util.Scanner;

public class Dome01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额:");
        int a = sc.nextInt();
        if(a >= 600){
            System.out.println("支付成功...");
        }else {
            System.out.println("支付失败...");
        }
    }
}
