package com.example.stringText;

import java.util.Scanner;

/**
 * 需求:
 * 阿拉伯数字转罗马数字
 * 键盘录入一个字符串
 * 1.长度不大于9,只能是数字
 * 2.罗马数字没有0用""代替
 * I	1
 * II	2
 * III	3
 * IV	4
 * V	5
 * VI	6
 * VII	7
 * VIII	8
 * IX   9
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strNumber;
        while (true) {
            System.out.println("请输入数字:");
            strNumber= sc.next();
            boolean frag = judge(strNumber);
            if (frag){
                break;
            }else {
                System.out.println("输入不合法...");
                continue;
            }
        }
        //查表法
        String str = "";
        //使用StringBuilder方法对字符串相加
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNumber.length(); i++) {
            char c = strNumber.charAt(i);
            //字符与数字之间的转换操作
            int num = c -48;
            sb.append(numToLuo(num)).toString();
        }

        System.out.println(sb);

    }
    //数字转罗马数字
    public static String numToLuo(int number){
        //1.switch

        //2.可以使用查表法
        String[] arr={" ","I","II","III","IV","V","VI","VII","VIII","IX"};
        return arr[number];
    }
    //
    public static boolean judge(String strNumber){
        //1.判断长度
        if (strNumber.length()>9){
            return false;
        }
        //2.数字判断
        for (int i = 0; i < strNumber.length(); i++) {
            char c = strNumber.charAt(i);
            if (c < '0' || c>'9'){
                return false;
            }
        }
        return true;
    }
}
