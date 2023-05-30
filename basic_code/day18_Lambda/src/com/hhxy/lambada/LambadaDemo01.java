package com.hhxy.lambada;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 需求:
 * 使用java内方法对数组进行排序
 */
public class LambadaDemo01 {
    public static void main(String[] args) {
        //必须是引用类型的数据,如果是基本数据类型,需要进行包装
        Integer[] arr={3,1,2,4,8,5,7,9,11,6};
        //若只调用此方法只会对数据进行升序排序
        //Arrays.sort(arr);
        //使用的是插入排序+二分查找(重写接口的原因是为了可以对数据的排序方式进行改变)--匿名内部类
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1-o2 : 升序
                //o2-o1  :降序
                return o1-o2;
            }
        });
        //Arrays.toString(arr)用于打印数组,且以字符串进行拼接
        System.out.println(Arrays.toString(arr));
    }
}
