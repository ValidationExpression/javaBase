package com.hhxy.SuanFa.Paixu;

/**
 * 选择排序
 */
public class Demo02_XuanZe {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 2};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
