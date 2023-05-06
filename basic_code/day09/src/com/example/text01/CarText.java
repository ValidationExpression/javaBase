package com.example.text01;

import java.util.Scanner;

public class CarText {
    public static void main(String[] args) {
        //定义数组
        Car[] cars = new Car[3];

        //键盘输入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cars.length; i++) {
            //实例化Car类
            Car c = new Car();//如果实例化类在循环外会导致最后的结果只会有最后一辆车的信息.(原因是每一辆车都应该有一个对象产生)
            System.out.println("品牌:");
            String b = sc.next();
            c.setBroad(b);

            System.out.println("价格:");
            int p = sc.nextInt();
            c.setPrice(p);

            System.out.println("颜色:");
            String color = sc.next();
            c.setColor(color);

            cars[i] = c;
        }

        for (int i = 0; i < cars.length; i++) {
            //索引汽车对象
            Car c = cars[i];
            System.out.println(c.getBroad()+","+c.getPrice()+","+c.getColor());
        }
    }
}
