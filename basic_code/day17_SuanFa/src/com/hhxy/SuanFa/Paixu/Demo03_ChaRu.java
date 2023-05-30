package com.hhxy.SuanFa.Paixu;

public class Demo03_ChaRu {
    public static void main(String[] args) {
        int [] arr={3,34,1,23,45,56,23,56,3,2,67};

        //寻找无序索引
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>arr[i+1]){
                index = i+1;
                break;
            }
        }

        //遍历无序数组
        for (int i = index; i < arr.length; i++) {
            //先保存起始索引
            int j=i;
            //结束条件j>0,拿无序数组中的数据与有序中的数据进行比较,满足条件时便插入数据.
            while (j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
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
