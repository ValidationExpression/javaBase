package com;

public class Demo02 {
    public static void main(String[] args) {
        //算数平方根
        int a=2147395599;

        if (a==1){
            System.out.println(a);
        }
        for(int i = (int) Math.floor(a/2); i>=1; i--){
            if (i*i>a){
                continue;
            }
            System.out.println(i);
            break;
        }
    }
}
