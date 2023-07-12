package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo03 {
    public static void main(String[] args) {
        /**
         * 需求:班级有N名同学
         * 要求:被点到的同学不会被再次点到,
         * 当所有同学都点完,会开启新的一轮点名
         */
        ArrayList<String> list =new ArrayList<>();
        //使用Collections集合的api接口操作集合
        Collections.addAll(list,"a","b","c","d","e");
        //定义一个临时数组,存储被删除的人
        ArrayList<String> list1 =new ArrayList<>();


        //外循环,控制轮数
        for (int i = 0; i < 3; i++) {
            System.out.println("============="+i+"轮==============");
            //定义一个变量存储数组长度
            int count=list.size();
            //随机抽取
            Random r=new Random();
            for (int j = 0; j < count; j++) {
                int index=r.nextInt(list.size());
                //调用集合的remove方法,由于他会返回被删除的值.所以接收其中的值即可
                String name = list.remove(index);
                list1.add(name);
                System.out.println(name);
            }
            //将临时变量赋给
            list.addAll(list1);
            //清除临时变量数组的元素
            list1.clear();
        }
    }
}
