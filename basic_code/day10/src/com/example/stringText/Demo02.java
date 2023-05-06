package com.example.stringText;

/**
 * 需求:
 * 字符串旋转,
 * 例子:A="abcde" -->"bcdea" -->"cdeab" ...
 *     B="bcdea"
 *     就是将A字符串的最左边的字符放到最右边,以产生旋转
 *     结论如果在旋转若干次后可以使A,B字符串相等则返回true,否则false
 */
public class Demo02 {
    public static void main(String[] args) {
        String strA = "abcde";
        String strB = "cdeab";

        //A,B字符串匹配操作应当使字符串循环一遍,
        /**
         * strA = "abcde"
         *      ->"bcdea"
         *      ->"cdeab"
         *      ->"deabc"
         *      ->"eabcd"
         *      ->"abcde"
         *      此时与第一个相等
         */
        boolean text = equalsString(strA,strB);
        System.out.println(text);

        //String strC = reverse(strA);
        //System.out.println(strC);
    }

    //定义用于判断字符串是否相等
    public static boolean equalsString(String strA,String strB){
        for (int i = 0; i < strA.length(); i++) {
            strA = reverse(strA);
            if (strA.equals(strB)){
                return true;
            }
        }
        return false;
    }

    //定义循环方法用于字符串的循环操作
    public static String reverse(String strA){
        //1.使用subString()截取字符串
        //char c = strA.charAt(0); //获取第一个字符
        //截取除第一个字符外的所有字符并进行相加操作
        //return strA.substring(1)+c;



        //2.方法使用字符数组的方式进行旋转
        char[] strC = strA.toCharArray(); //结果形式:['a','b','d'...]
        char first = strC[0]; //将第一个字符进行赋值
        for (int i = 1; i < strC.length; i++) {
            //原理就是将后一个向前移动一位
            strC[i-1]=strC[i];
        }
        //再将第一个字符放在最后
        strC[strC.length-1]=first;
        //将字符数组转换为字符串
        String result = new String(strC);
        return result;
    }
}
