package com.example.string;


import java.util.Scanner;

/**
 * 需求:
 * 进行数字与中文数字之间的转换与输出拼接,
 * 例子: 输入:321
 * 输出:壹、贰、叁、肆、伍、陆、柒、捌、玖
 * 零佰,零拾,零万,零仟,叁佰,贰拾,壹元(只有7位)
 */
public class StringDemo05 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入钱数:");
        int money;
        while (true) {
            money = sc.nextInt();
            //判断输入的钱是否合法
            if (money < 0 || money > 9999999) {
                System.out.println("输入的不合法...请重新输入?");
            } else {
                break;
            }
        }

        //2. 定义一个变量存储汉字数字
        String number = "";
        //得到数的每一位
        while (true) {
            //得出个位
            int ge = money % 10;
            //2. 定义一个方法用于对数字与汉字的匹配
            String moneyStr = getMoneyStr(ge);
            number = moneyStr + number;
            // 剩余位
            money = money / 10;
            if (money == 0) {
                break;
            }
        }
        System.out.println(number);

        //3. 格式输出
        int count = 7 - number.length();
        String zoo = "";
        for (int i = 0; i < count; i++) {
            zoo = "零" + zoo;
        }
        zoo = zoo+number;
        System.out.println(zoo);

        //带单位输出
        String[] array = {"佰","拾","万","仟","佰","拾","元"};
        String moneyStr = "";
        for (int i = 0; i < zoo.length(); i++) {
            char c = zoo.charAt(i);
            moneyStr = moneyStr+c +array[i];
        }
        System.out.println(moneyStr);

    }

    public static String getMoneyStr(int money) {
        //利用数组下标的特性进行对应
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return arr[money];
    }
}
