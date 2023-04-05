package com.hhxy.text;

import java.util.Random;

public class Dome10 {
    /**
     * 定义一个数组,对数组的內容进行随机打乱操作
     */
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //产生随机索引
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int number = r.nextInt(arr.length);
            //定义一个临时变量
            int temp = arr[i];
            arr[i]= arr[number];
            arr[number] = temp;
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }


    }
}
