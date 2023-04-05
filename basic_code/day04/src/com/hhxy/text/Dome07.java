package com.hhxy.text;

public class Dome07 {
    /**
     * 条件:一个数组的內容
     * 要求:
     * 1. 若为奇数,当前数字扩大两倍
     * 2. 若为偶数,当前数字变为原来的1/2
     */
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7,8,9,10};
        //遍历
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 0){
                arr[i] = arr[i]/2;
            }else {
                arr[i] = arr[i]*2;
            }
        }
        //遍历输出
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
