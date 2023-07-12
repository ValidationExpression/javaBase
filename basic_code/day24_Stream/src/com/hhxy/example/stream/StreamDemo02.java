package com.hhxy.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 定义一个集合,添加一些数据,1,2,3,4,5,6,7,8,9
 * 过滤奇数,留下偶数,
 * 结果存储
 */
public class StreamDemo02 {
    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();
        //使用Collections批量添加数据,
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9);
        List<Integer> collect = list.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
