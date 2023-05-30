package com.exqmple.text01;

public class DemoText {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        String str = ArrayUtil.printArr(arr);
        System.out.println(str);
        
        double[] arr1 = {1.1,1.1,1.2};
        ArrayUtil.getAverage(arr1);
    }
}
