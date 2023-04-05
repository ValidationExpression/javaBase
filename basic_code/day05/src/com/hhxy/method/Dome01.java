package com.hhxy.method;

public class Dome01 {
    /**
     * 需求:
     * 设计一个方法,用于数组的遍历,且结果在一行显示
     * @param args
     */
    public static void main(String[] args) {
        //定义数组
        int [] array={1,22,33,12,45};
        display(array);

    }
    //定义方法
    public static void display(int [] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i==array.length-1){
                System.out.print(array[i]+"]");
            }else {
                System.out.print(array[i]+",");
            }
        }
    }

}
