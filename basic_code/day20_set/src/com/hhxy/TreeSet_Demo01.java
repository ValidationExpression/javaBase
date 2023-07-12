package com.hhxy;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_Demo01 {
    public static void main(String[] args) {
        //创建TreeSet对象
        TreeSet<Integer> tr = new TreeSet<>();

        //添加数据
        tr.add(1);
        tr.add(4);
        tr.add(5);
        tr.add(4);
        tr.add(7);
        System.out.println(tr);

        //遍历器遍历
        Iterator<Integer> it= tr.iterator();
        while (it.hasNext()){
            //it.next()获取值并移动索引
            Integer i = it.next();
            System.out.println(i);
        }
    }
}
