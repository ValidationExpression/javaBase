package com.hhxy.dome;

import java.util.Scanner;

public class Dome03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的会员等级:");
        int a = sc.nextInt();
        //定义商品价格
        int b = 1000;
        //定义打折后的价格
        double c = 0;
        if(a == 1 | a == 2 | a == 3 ){
            if(a == 1){
                c = b*0.9;
            }else if(a == 2){
                c = b*0.8;
            }else if (a == 3){
                c = b*0.7;
            }
            System.out.println("你的会员等级是:"+a+",实际支付的金额是:"+ c);
        }else {
            System.out.println("你不属于会员,不打折,原价"+b);;
        }


    }
}
