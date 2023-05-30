package com.hhxy.SuanFa.Paixu;

/**
 * 快速排序
 */
public class Demo04_KuaiSu {
    public static void main(String[] args) {
        int [] arr={6,2,1,7,8,11,23,45,1,7,10};

        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void quickSort(int[] arr,int i,int j){
        int start=i;
        int end = j;
        //递归出口
        if (start>end){
            return;
        }
        //基准数
        int baseNumber = arr[i];
        while (start!=end){
            //end,从后往前(注意只能从后向前移动为起始)
            while (true){
                if (end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }
            //start,从前往后
            while (true){
                if (end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }
            //end,start处的索引元素进行交换
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        int temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
        //确定基数左的范围
        quickSort(arr,i,start-1);
        //确定基数右的范围
        quickSort(arr,start+1,j);
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
