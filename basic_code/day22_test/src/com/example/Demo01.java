package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo01 {
    public static void main(String[] args) {
        /**
         * 需求:班级有N名同学,学生属性,姓名,年龄,性别
         * 实现随机点名
         */
        ArrayList<String> list =new ArrayList<>();
        //使用Collections集合的api接口操作集合
        Collections.addAll(list,"a","b","c","d","e","f");
        System.out.println(list);
        //随机打乱数组(后获取0索引的位置即可)
        //Collections.shuffle(list);
        //System.out.println(list.get(0));
        Random r=new Random();
        int i=r.nextInt(list.size());
        System.out.println(list.get(i));

    }
}
