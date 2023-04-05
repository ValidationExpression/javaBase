package com.hhxy.text;

import java.util.Scanner;

public class Dome01 {
    /**
     * 需求:
     * 飞机买票
     * 机票价格按照淡季旺季,头等舱和经济舱收费,输入机票原价,月份,头等舱或经济舱.
     * 按照如下价格计算票价,旺季(5-10)月,头等舱9折,经济舱8.5折,淡季(11-下一年4月)头等舱7折,经济舱6.5折.
     */
    /**
     * 抽取方法快捷键 : Ctrl+Alt+M 后 回车进行选择
     * 代码格式: Ctrl+Alt+L
     */
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入票价:" + " ");
        double price = sc.nextDouble();
        System.out.print("请输入月份:" + " ");
        int month = sc.nextInt();
        System.out.print("请输入舱型(0表示头等舱,1表示经济舱):" + " ");
        int airplaneType = sc.nextInt();

        //首先判断淡旺季,在者判断舱型
        if (month >= 5 && month <= 10) {
            //旺季
            price = getPrice(airplaneType, price, 0.9, 0.85);
        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            //淡季
            price = getPrice(airplaneType, price, 0.7, 0.65);
        } else {
            System.out.println("月份不合法...");
        }
        System.out.println("机票价格:" + price);

    }

    private static double getPrice(int airplaneType, double price, double x, double x1) {
        if (airplaneType == 0) {
            //舱型头等舱
            price = price * x;
        } else if (airplaneType == 1) {
            //舱型经济舱
            price = price * x1;
        } else {
            System.out.println("没有这个舱型");
        }
        return price;
    }
}
