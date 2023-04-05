package com.hhxy.text;

import java.util.Random;
import java.util.Scanner;

public class Dome07 {
    /**
     * 需求:
     * 彩票双色球,
     * 1.投注号码为六个红色球,一个蓝色球.
     * 2.红色球从1-33中选择,蓝色球从1-16中选择.
     */
    /**
     * 奖池(数字存在即为中奖)
     * 1.红中六个,蓝中1个 ---1000万
     * 2.红中6个,蓝0个   ---500万
     * 3.红5个,蓝1个    ---3000
     * 4.红5个,蓝0个    ---200
     * 5.红4个,蓝1个    ---200
     * 6.红4个,蓝0个    ---10
     * 7.红3个,蓝1个    ---10
     * 8.红2个,蓝1个    ---5
     * 9.红1个,蓝1个    ---5
     * 10.红0,蓝1个     ---5
     */
    public static void main(String[] args) {
        //1.生成中奖号
        int [] arr = createNumber();

        //2.用户输入红球+蓝球
        int[] userInput = userInputNumber();
        //3.判断中奖情况
        int redCount = 0;
        int blueCount = 0;
        //判断红球中奖情况(数字存在即可,不需要顺序一样)
        for (int i = 0; i < userInput.length-1; i++) {
            int redNumber = userInput[i];
            for (int j = 0; j < arr.length-1; j++) {
                //如果满足条件
                if (redNumber == arr[j]){
                    redCount++;
                    //满足条件后,跳出循环
                    break;
                }
            }
        }

        //判断蓝球中奖情况(数字存在即可,不需要顺序一样)
        int blueNumber = userInput[userInput.length-1];
        if (blueNumber == arr[arr.length-1]){
            blueCount++;
        }
        //4.根据红球与蓝球个数,判断中奖情况
        if (redCount == 6 && blueCount ==1){
            System.out.println("1000万");
        } else if (redCount == 6 && blueCount==0) {
            System.out.println("500万");
        } else if (redCount == 5 && blueCount ==1) {
            System.out.println("3000");
        } else if ((redCount == 5&&blueCount==0) || (redCount==4&&blueCount==1)) {
            System.out.println("200");
        }else if ((redCount == 4&&blueCount==0) || (redCount==3&&blueCount==1)){
            System.out.println("10");
        } else if ((redCount == 2&&blueCount==1) || (redCount==1&&blueCount==1) || (redCount==0&&blueCount==1)) {
            System.out.println("5");
        }else {
            System.out.println("谢谢参与...");
        }
    }

    //用户输入号码
    public static int[] userInputNumber(){
        //用于存储用户输入的号
        int[] arr=new int[7];
        //键盘输入
        Scanner sc = new Scanner(System.in);
        //用户输入
        for (int i = 0; i < 6; ) {
            System.out.print("请输入第"+(i+1)+"个号码:");
            int redNumber = sc.nextInt();
            if (redNumber >= 1 && redNumber <= 33){
                boolean flag = contain(arr,redNumber);
                if (!flag){
                    arr[i] = redNumber;
                    i++;
                }else {
                    System.out.println("当前红球已经存在,请重新输入...");
                }
            }else {
                System.out.println("数字超出范围");
            }
        }
        System.out.println("请输入蓝球号");
        //1-16个蓝球
        while (true) {
            int blueNumber = sc.nextInt();
            if (blueNumber >= 1 && blueNumber<=16){
                arr[arr.length-1] = blueNumber;
                break;
            }else {
                System.out.println("数字超出范围");
            }
        }
        return arr;
    }

    //随机创建中奖号
    public static int[] createNumber(){
        //定义数组用于存储号码
        int [] arr = new int[7];
        //产生随机数
        //条件:红球不能重复,蓝球可以和红球重复
        Random ra = new Random();
        for (int i = 0; i < 6; ) {
            //红球
            int redNumber = ra.nextInt(33)+1;
            //调用判断方法,判别数组中的数字是否有重复的
            boolean flag = contain(arr,redNumber);
            if (!flag){
                //将红球放入到数组
                arr[i] = redNumber;
                i++;//只有满足条件是数组下标才会变化
            }
        }
        //生成蓝球号
        int blueNumber = ra.nextInt(16)+1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }
    //用于判断随机产生的红球是否已经存在
    public static boolean contain(int[]arr ,int redNumber){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == redNumber){
                return true;
            }
        }
        return false;
    }
}
