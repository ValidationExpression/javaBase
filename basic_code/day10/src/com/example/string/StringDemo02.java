package com.example.string;

import java.util.Scanner;

/**
 * 实现:计算一个字符串中有多少大写字母,小写字母,数字
 */
public class StringDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String text = sc.next();
        //定义计数变量
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char chars = text.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                smallCount++;
            } else if (chars >= 'A' && chars <= 'Z') {
                bigCount++;
            } else if (chars >= '0' && chars <= '9') {
                numberCount++;
            }
        }
        System.out.println("大写字母有" + bigCount);
        System.out.println("小写字母有" + smallCount);
        System.out.println("数字字母有" + numberCount);
    }
}
