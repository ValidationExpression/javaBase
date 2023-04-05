package com.hhxy.method;

public class Dome02 {
    /**
     * 需求:
     * 设计一个方法求数组的最大值,并将最大值返回
     */
    public static void main(String[] args) {
        int [] array={1,2,3,43,2,6};
        //调用方法
        int arrayMax=max(array);
        System.out.println("数组最大值是:"+arrayMax);

    }
    //定义方法
    public static int max(int [] array){
        //定义一个变量用于存储比较值
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (temp < array[i]){
                temp = array[i];
            }
        }
        return temp;
    }
}
