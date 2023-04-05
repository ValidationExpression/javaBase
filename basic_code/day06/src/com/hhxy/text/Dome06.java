package com.hhxy.text;

public class Dome06 {
    /**
     * 需求:
     * 规则:每一位数字+5
     *            对10求余
     *            数字反转
     *            新的一组数据
     * 对Dome05的加密数字进行解密.
     * 解题思路:可以使用方向推导,有结论推过程
     */
    public static void main(String[] args) {
        //加密值
        int number = 8346;
        //定义number临时变量
        int temp = number;
        //1.将数字存入数组中
        //定义一个变量用于存储加密值的个数
        int count = 0;
        while (number != 0){
            //去掉个位的值
            number = number/10;
            count++;
        }
        //2.定义动态数组用于存储数字
        int[] arr = new int[count];
        int index = arr.length-1;
        while (temp != 0){
            //得出个位的值
            int ge = temp%10;
            //去掉个位的值
            temp = temp/10;
            arr[index] = ge;
            index--;
        }
        //3.数组反向
        for (int i = 0,j=arr.length-1; i < j; i++,j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] =tmp;
        }
        /**
         * 应当注意逆向推的最后两个条件
         * --1.每一位数字+5   1  9  8  3
         * --2.对10求余      6  14 13  8(如果不考虑第一个条件还可能存在 : 16, 24,23, 18等其他情况)
         *                             解决方法:数字只可能在(0-9)之间
         *                             5 ,6 ,7 ,8 ,9, 10 ,11 ,12 ,13 ,14
         *                    对10取余  5 ,6 ,7 ,8 ,9, 0, 1, 2, 3, 4
         *                    所以可以根据范围来确定数(0-4)加上10,(5-9)不变
         * --3.数字反转       6   4  3  8
         */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >=0 && arr[i]<=4){
                arr[i] = arr[i]+10;
            }
        }
        //5.remove -5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]-5;
        }
        //6.获取最后结果
        int numb = 0;
        for (int i = 0; i < arr.length; i++) {
            numb = numb*10 +arr[i];
        }
        System.out.println(numb);
    }
}
