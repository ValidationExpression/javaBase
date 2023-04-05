package com.hhxy.dome;

public class Dome04 {
    //一定要注意主函数的书写
    public static void main(String[] args) {
        //计算1-100偶数的和
        //定义存储变量
        int sum = 0;
        for(int i=0; i<=100;i++){
            if(i%2==0){
                sum = sum+i;
            }
        }
        System.out.println("偶数的和是:"+sum);
    }


}
