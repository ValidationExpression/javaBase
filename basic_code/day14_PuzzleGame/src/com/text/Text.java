package com.text;

import java.util.Random;

public class Text {
    public static void main(String[] args) {
        //1.游戏创建界面
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //获取随机索引
            int index = r.nextInt(arr.length);
            //
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //创建二维数组
        int[][] data = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            data[i/4][i%4]=arr[i];
        }
        //遍历
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }


    }
}
