package com.hhxy.lambada;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03 {
    public static void main(String[] args) {
        String[] arr={"a","aaaa","aa","aaa"};

        //1.
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        //2.
        Arrays.sort(arr, (String o1, String o2)-> {
            return o1.length() - o2.length();
        });
        //3.
        Arrays.sort(arr, (o1, o2)-> o1.length() - o2.length());

        System.out.println(Arrays.toString(arr));
    }
}
