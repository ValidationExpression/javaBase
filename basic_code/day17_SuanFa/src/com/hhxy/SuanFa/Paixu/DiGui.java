package com.hhxy.SuanFa.Paixu;

public class DiGui {
    public static void main(String[] args) {
        System.out.println(getFactorialRecursion(5));
    }
    public static int getFactorialRecursion(int number){
        if (number==1){
            return 1;
        }
        return number*getFactorialRecursion(number-1);
    }
}
