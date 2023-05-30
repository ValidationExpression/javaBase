package com.hhxy.SuanFa.Paixu;

/**
 * 冒泡排序
 */
public class Demo01_MaoPao {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 2};

        //外层循环表示执行轮数
        for (int j = 0; j < arr.length-1; j++) {
            //内层循环进行比较,长度-1是为了防止数组越界
            for (int i = 0; i < arr.length - j -1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        printArr(arr);

    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
