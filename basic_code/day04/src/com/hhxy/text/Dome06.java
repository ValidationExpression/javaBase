package com.hhxy.text;

public class Dome06 {
    /**
     * 统计一个数组中有多少个可以被3整除的值
     */
    public static void main(String[] args) {
        int [] array ={1,2,3,4,5,6,7,8,9,12};
        //定义一个计数变量
        int count = 0;
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            if(array[i]%3 == 0){
                count++;
                System.out.println(array[i]);
            }
        }
        System.out.println("个数:"+count);
    }



}
