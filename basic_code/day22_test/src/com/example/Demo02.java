package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        /**
         * 需求:班级有N名同学
         * 要求:70%概率抽出男生
         *      30%概率抽出女生
         * 实现随机点名
         * 女:a,b,c,d,e
         * 男:f,g,h,i,j,k,l,m,n
         *
         * 实现思路:定义一个数组存储[1,1,1,1,1,1,1,0,0,0]
         * 为7个1,3个0,其中抽查1表示男生,0表示女生,然后在从不同数组中抽取
         */
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<String> list2 =new ArrayList<>();
        //使用Collections集合的api接口操作集合
        Collections.addAll(list1,"a","b","c","d","e");
        Collections.addAll(list2,"f","g","h","i","j","k","l","m","n");
        //概率判断问题
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1,0,0,0);
        Collections.shuffle(list);
        System.out.println(list);
        //随机抽取
        Random r=new Random();
        int i=r.nextInt(list.size());
        if (list.get(i)==1){
            int index2=r.nextInt(list2.size());
            System.out.println("男"+list2.get(index2));
        }else if (list.get(i)==0){
            int index1=r.nextInt(list1.size());
            System.out.println("女"+list1.get(index1));
        }

    }
}
