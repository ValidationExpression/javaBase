package com.example.string;

import java.util.Scanner;

/**
 * 实现用户登录
 * 三次机会
 */

public class StringDemo01 {
    public static void main(String[] args) {
        //定义账号密码
        String account = "aaa";
        String password = "111";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入账号:");
            String inputAccount = sc.next();
            System.out.println("请输入密码:");
            String inputPassword = sc.next();
            if (inputAccount.equals(account) && inputPassword.equals(password)) {
                System.out.println("登录成功");

            } else {
                System.out.println("账号或密码有误...还有"+(2-i)+"次机会");
            }
        }


    }
}
