package com.example.string;

//字符串反转
public class StringDemo04 {
    public static void main(String[] args) {
        String text = "abc";
        revers(text);
    }
    public static void revers(String text){
        String newText="";
        //逆序输出
        for (int i = text.length()-1; i >= 0; i--) {
            char c = text.charAt(i);
            newText=newText+c;
        }
        System.out.println(newText);

        //方法二使用的是字符串相加的特性,
        String newText1="";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            System.out.println(c);
            //重点是这里对相加的顺序进行调整
            newText1 = c + newText1;
        }
        System.out.println(newText1);
    }
}
