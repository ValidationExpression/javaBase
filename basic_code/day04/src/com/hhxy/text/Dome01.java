package com.hhxy.text;

public class Dome01 {
    /**
     * 条件1-100数字,包含7或7的倍数时,应输出过
     */
    public static void main(String[] args) {
        for (int i = 1; i<=100; i++){
            if(i%7 == 0 || i/10%10 == 7 || i%10 ==7){
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }
    }
}
