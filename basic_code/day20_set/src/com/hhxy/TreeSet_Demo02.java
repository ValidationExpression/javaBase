package com.hhxy;


import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_Demo02 {
    public static void main(String[] args) {
        /**
         * 测试要求:
         * 一些字符"c","ds","arf","ab"
         * 将其进行排序:条件先按照字符串长度进行比较,在按ascoll表的顺序排序
         *
         * 使用的是比较器比较
         */
        TreeSet<String> tr=new TreeSet<>(new Comparator<String>() {
            // o1表示的是当前要添加的元素,
            // o2表示的已经存入到红黑树的元素
            @Override
            public int compare(String o1, String o2) {
                //长度比较
                int i=o1.length()- o2.length();
                //三元运算符--含义如果i==0则使用compareTo的比较方式,否则返回i
                i = i==0?o1.compareTo(o2):i;
                return i;
            }
        });
        tr.add("c");
        tr.add("ds");
        tr.add("ab");
        tr.add("arf");
        System.out.println(tr);

    }
}
