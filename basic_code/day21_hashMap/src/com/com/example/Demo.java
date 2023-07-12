package com.com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 *需求:
 * 某班有80个学生,现在要组成秋游活动,
 * 现在有四个景点(A,B,C,D)
 * 每个学生只能选择一个景点,统计那个景点的人数最多
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * 解题思路:使用HashMap<K,V>对象 <A,1>
         * 将景点设置为K,去的人数设置为V
         * 使用循环遍历K,是否已经存在,如果存在则将V的值加 1
         * 由于此类集合的特性:不会重复,且值会进行覆盖
         */
        //定义景点数组
        String[] arr={"A","B","C","D"};
        //使用随机数产生学生的选择--并存入到集合中
        ArrayList<String> list=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 80; i++) {
            //产生数组的索引
            int index = r.nextInt(arr.length);
            String s = arr[index];
            //将结果放入到集合中
            list.add(s);
        }

        //定义一个集合
        HashMap<String,Integer> hh=new HashMap<>();
        for (String name : list) {
            //使用containsKey方法判断name是否已经存在
            if (hh.containsKey(name)){
                //获取到值
                int count = hh.get(name);
                count++;
                hh.put(name,count);
            }else {
                //如果不包含则在集合中添加一个
                hh.put(name,1);
            }
        }

        //使用Set(根据键找值)的遍历方式,
        Set<String> s=hh.keySet();
        for (String name : s) {
            int count = hh.get(name);
            System.out.println(name+":"+count);
        }
    }
}
