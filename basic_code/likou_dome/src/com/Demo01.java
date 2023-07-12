package com;

public class Demo01 {
    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        int num1 = Integer.parseInt(a, 2); // 将 "11" 解析为二进制数
        int num2 = Integer.parseInt(b, 2); // 将 "1" 解析为二进制数
        int result = num1 + num2; // 进行二进制加法运算
        String binaryResult = Integer.toBinaryString(result); // 将结果转换为二进制字符串
        System.out.println(binaryResult); // 输出结果：100
    }
}
