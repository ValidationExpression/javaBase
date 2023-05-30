package scannerText;

import java.util.Scanner;

/**
 * 使用Integer.parseInt(s);将字符转int类型
 * 条件:1.只能是数字不能有其他字符
 *      2.长度1-10
 *      3.不能零开头
 */

public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入");
        String s = sc.nextLine();
        if (judge1(s)){
            int num = Integer.parseInt(s);
            System.out.println(num);
        }else {
            System.out.println("输入的字符不符合条件");
        }
    }
    //定义一个方法判读输入的字符是否合法
    public static boolean judge(String s){
        if (s.length()>10 || s.length()<1){
            System.out.println("输入不符合条件");
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>'0' && c<'9' && s.charAt(0)!=0 ){
                return true;
            }
        }
        return false;
    }
    //方法二使用正则表达式
    public static boolean judge1(String s){
        if (s.matches("[1-9]\\d{0,9}")){
            return true;
        }
        return false;
    }
}
