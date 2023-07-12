package com.hhxy;

public class Demo01_fanxing_Text {
    public static void main(String[] args) {
        //此时自定义为String 类型
        Demo01_fanxing<String> list =new  Demo01_fanxing<>();
        list.add("aaa");
        list.add("aab");
        System.out.println(list);
    }
}
