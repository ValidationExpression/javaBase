package com.hhxy.text;

public class Dome05 {
    /**
     * 数组內容求和
     */
    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6};
        //定义一个存储变量
        int c = 0;
        //遍历
        for (int i = 0; i < array.length; i++) {
            c = c + array[i];
        }
        System.out.println(c);
    }
}
