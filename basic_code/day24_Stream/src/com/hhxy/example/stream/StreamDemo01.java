package com.hhxy.example.stream;

import java.util.ArrayList;

/**
 * 要求:
 * 过滤出姓张的人,且为三个字的
 */
public class StreamDemo01 {
    public static void main(String[] args) {

        ArrayList<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("赵明");
        list.add("张强");
        list.add("张算法");
        list.add("周芷若");

        //方法1
        //先遍历数组,将姓张的人取出,放入其他数组
        ArrayList<String> list1=new ArrayList<>();
        for (String s : list) {
            boolean a = s.startsWith("张");
            if (a){
                list1.add(s);
            }
        }
        System.out.println(list1);
        //在进行对list1数组的遍历,并将满足条件的放入新的数组
        ArrayList<String> list2=new ArrayList<>();
        for (String s : list1) {
            if(s.length()==3){
                list2.add(s);
            }
        }
        System.out.println(list2);

        //方法2
        //使用Stream流的方式
        list.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(name-> System.out.println(name));


    }
}
