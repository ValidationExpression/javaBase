package com.hhxy.text;

public class Dome08 {
    /**
     * 找出一个数组中的最大值
     */
    public static void main(String[] args) {
        int [] arr ={22,43,12,56,45};
        //首先默认第一个为最大(必须是数组里的值)
        int max = arr[0];
        //遍历比较
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
