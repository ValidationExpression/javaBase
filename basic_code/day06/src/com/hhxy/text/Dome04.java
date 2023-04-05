package com.hhxy.text;

import java.util.Scanner;

public class Dome04 {
    /**
     * 需求:
     * 评委打分,6个评委,分数(0-100),去掉最高分和最低分后计算平均分.即为选手得分
     */
    public static void main(String[] args) {
        //定义一个数组用于存储评委打分
        double[] score = new double[6];
        //键盘输入
        double[] scoreArr = getScore(score);
        //定义此时数组最大值
        double max = score[0];
        double min = score[0];
        //遍历
        for (int i = 1; i < score.length; i++) {
            if (max < score[i]){
                max = score[i];
            }
            if (min > score[i]){
                min = score[i];
            }
        }
        //调用方法求分数和
        double sum = getSum(score);
        //平均分是
        double avg = (sum-max-min)/(score.length-2);
        System.out.println("选手最终得分是:"+avg);
    }
    //求分数总和
    public static double getSum(double[] score){
        //定义求和变量
        double sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum = sum+score[i];
        }
        return sum;
    }
    //评委打分
    public static double[] getScore(double[] score) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; ) {
            System.out.print("评委"+(i+1)+"打分: ");
            double score01 = sc.nextDouble();
            //应当进行分数判断,用于对于超出的分时有识别(考虑全面)
            if (score01 >= 0 && score01 <= 100){
                //满足条件时才执行插入操作
                score[i] = score01;
                //但为了防止在输入错误值时,数组索引还加,去除for循环的i++
                i++;
            }else {
                System.out.println("输入的分数不合法...,请重新输入....");
            }
        }
        return score;
    }
}
