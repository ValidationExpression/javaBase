package com.hhxy.text;

import java.util.Scanner;

public class Dome05 {
    /**
     * 需求:数字加密
     * 规则:每一位数字+5
     *      对10求余
     *      数字反转
     *      新的一组数据
     *      错误:ArrayIndexOutOfBoundsException:数组越界
     */
    public static void main(String[] args) {
        //定义一个数组用于存储数字
        int[] number = new int[4];
        int [] numberNew = getNumber(number);
        //对数字加5
        addNumber(numberNew);
        //对10求余
        modNumber(numberNew);
        //数字反转
        reverseNumber(numberNew);
        //结果输出1
        System.out.print("加密后的数字是:");
        for (int i = 0; i < numberNew.length; i++) {
            System.out.print(numberNew[i]+" ");
        }
        //结果输出2
        int num = 0;
        for (int i = 0; i < numberNew.length; i++) {
            //实现数字放大
            num = num*10+numberNew[i];
        }
        System.out.println(num);
    }

    public static int[] reverseNumber(int[] numberNew){
        //定义临时变量
        int temp = 0;
        for (int i = 0,j = numberNew.length-1; i < j; i++,j--) {
                temp = numberNew[i];
                numberNew[i] = numberNew[j];
                numberNew[j] = temp;
        }
        return numberNew;
    }

    public static int[] modNumber(int[] numberNew){
        for (int i = 0; i < numberNew.length; i++) {
            numberNew[i] = numberNew[i]%10;
        }
        return numberNew;
    }


    //对数字进行加5操作
    public static int[] addNumber(int[] numberNew){
        for (int i = 0; i < numberNew.length; i++) {
            numberNew[i] = numberNew[i]+5;
        }
        return numberNew;
    }
    //对输入的数字存放在数组中
    public static int[] getNumber(int[] number){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入"+number.length+"个数字");
        for (int i = 0; i < number.length; i++) {
            int num = sc.nextInt();
            number[i] = num;
        }
        return number;
    }
}
