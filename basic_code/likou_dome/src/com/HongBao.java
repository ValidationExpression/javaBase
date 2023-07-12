package com;

public class HongBao {
    public static void main(String[] args) {
        randomHongBao(100,10);
    }

    //随机
    public static void randomHongBao(double money,int count){
        for (int i = 0; i < count-1; i++) {
            //平均值
            double avg=money/count;
            //向下取整
            double number=(Math.floor(Math.random()*avg*2*100)+1)/100.0;   //[0,1) --[0,2000)
            System.out.println(number);
            money-=number;
        }
        System.out.println(Math.round(money*100)/100.0);
    }
}
