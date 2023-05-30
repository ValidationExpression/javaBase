package com.exqmple.text01;

/**
 * 需求:
 * printArr()提供一个方法用于返回整数数组的內容
 * getAverage()提供一个返回平均分
 */
public class ArrayUtil {
    //私有化构造方法-目的:不让外界创建其对象
    private ArrayUtil() {
    }

    //方法设为静态方便调用
    public static String printArr(int[] arr) {
        //创建一个字符存储对象
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                str.append(arr[i]);
            } else {
                str.append(arr[i]).append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    public static double getAverage(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum / arr.length;
    }

}
