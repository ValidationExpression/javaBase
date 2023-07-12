package com.hhxy.example.stream.exception;

import java.util.Scanner;

/**
 * 异常的测试:
 * 需求:键盘录入学生的姓名,年龄
 * 姓名长度3~10之间
 * 年龄范围18~30
 * 超出这个范围的数据不会赋值,需重新录入,一直到正确为止
 * <p>
 * 提示:要考虑录入年龄的所有情况,例如输入字符a ,af等
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {

        //键盘录入
        Scanner sc = new Scanner(System.in);

        Person person=new Person();
        //使用while循环进行输入
        while (true) {
            try {
                System.out.println("姓名:");
                String name = sc.nextLine();
                //放入javabean中(异常判断写在了javabean中)
                person.setName(name);
                System.out.println("年龄:");
                String ages = sc.nextLine();
                int age = Integer.parseInt(ages);
                person.setAge(age);
                //当所有数据都正确时,
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println(person);

    }

}
