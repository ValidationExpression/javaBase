package com.hhxy.method;

public class Dome03 {
    /**
     * 需求:
     * 将一个数组中的部分元素赋值到新的列表中
     * 给定要复制的元素范围(含前不含后)
     */
    public static void main(String[] args) {
        //原数组
        int [] array = {1,2,3,4,5,6,7,8,9};

        int [] newArray = copy(array,3,7);
        text(newArray);

    }

    //定义复制方法
    public static int[] copy(int [] array, int from, int to){
        //定义新数组(动态)
        int [] newArray = new int[to-from];
        //定义一个数组伪索引
        int j = 0;
        for (int i = from; i < to; i++) {
            //数组赋值方法
            newArray[j] =array[i];
            j++;
        }
        return newArray;
    }

    //数组遍历方法
    public static void text(int [] newArray){
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
