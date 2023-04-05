package com.hhxy.text;

import java.util.Random;

public class Dome09 {
    /**
     * 条件:
     * 1.随机产生10个1-100的数字,存储到动态数组中.
     * 2. 求和
     * 3. 求平均值
     * 4. 求数组中比平均值小的个数
     */
    public static void main(String[] args) {
        int [] arr = new int[10];
        //产生随机数-并写入数组
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int number = r.nextInt(100)+1;
            arr[i] = number;
        }
        //定义一个变量用于存储求和的值
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("数组和:"+sum);
        //求平均值
        int equalsum = sum/arr.length;
        System.out.println("平均值:"+equalsum);
        //定义个数
        int count = 0;
        //遍历数组中小于平均数的个数
        for (int i = 0; i < arr.length; i++) {
            if (equalsum>arr[i]){
                count++;
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("个数:"+count);
    }
}
