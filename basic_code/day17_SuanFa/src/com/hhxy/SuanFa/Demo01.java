package com.hhxy.SuanFa;

import java.util.ArrayList;

/**
 * 需求:定义一个方法,使用基本查找,查询某个元素在数组中的索引
 * 要求:1.不需要考虑数组元素重复
 * 要求:2.需要考虑数组元素重复
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.
        int[] arr = {1,3,345,23,46,23,56,67,6};
        int number =6;
        System.out.println(basicSearch(arr, number));
        //2.
        int[] arr1 = {1,3,6,345,23,46,23,56,67,6};
        int number1 =6;
        ArrayList<Integer> list=basicSearch1(arr1,number1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }

    //没有考虑元素重复问题
    public static int basicSearch(int[] arr,int number){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==number){
                return i;
            }
        }
        return -1;
    }
    //考虑元素重复问题
    public static ArrayList<Integer> basicSearch1(int[] arr,int number){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==number){
                integers.add(i);
            }
        }
        return integers;
    }
}
