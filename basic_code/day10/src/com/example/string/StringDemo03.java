package com.example.string;


/**
 * 实现:一个数组int arr[] = {1,2,3}以如下格式输出:[1,2,3]
 */
public class StringDemo03 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        arrToString(arr);

    }

    //定义一个方法(1.干什么,2.怎样干,3.是否需要返回值)
    public static void arrToString(int[] arr) {
        String st = new String();
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                st = st + arr[i] + ", ";
            } else {
                st = st + arr[i];
            }
        }
        System.out.println("[" + st + "]");
    }
}
