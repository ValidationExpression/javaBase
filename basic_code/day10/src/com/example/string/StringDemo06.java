package com.example.string;

/**
 * 需求:
 * 根据身份证号判断其出生日期和性别
 * 其中:7-14位是出生日期,17位为性别(奇数为男,偶数为女)
 */
public class StringDemo06 {
    public static void main(String[] args) {
        String id = "412822200004090813";
        String year = id.substring(6,14);
        //定义性别
        String sex="";
        char c = id.charAt(16);
        System.out.println(c);
        int sexc = c;
        System.out.println(sexc);
        if (sexc % 2==0){
            sex = "女";
        }else {
            sex="男";
        }

        System.out.println("出生日期:"+year+",性别:"+sex);
    }
}
