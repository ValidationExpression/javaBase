package com.example.stringText;

/**
 * 需求:给定两个字符串(非负整数),计算其乘积
 */
public class Text03 {
    public static void main(String[] args) {
        String num1 = "123444";
        String num2 = "123";
        System.out.println(product(num1, num2));

    }

    public static int product(String num1, String num2) {
        //定义一个记录长度的变量
        int str1Long = num1.length() - 1;
        //
        int sum1 = 0;
        for (int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(i);
            int num1Result = c - 48;
            int m = (int) Math.pow(10, str1Long);
            sum1 = sum1 + num1Result * m;
            str1Long--;
            // System.out.println(num1Result);
        }

        int str2Long = num2.length() - 1;
        int sum2 = 0;
        for (int i = 0; i < num2.length(); i++) {
            char c = num2.charAt(i);
            int num2Result = c - 48;
            int m = (int) Math.pow(10, str2Long);
            sum2 = sum2 + num2Result * m;
            str2Long--;
        }
        return sum1*sum2;
    }
}
