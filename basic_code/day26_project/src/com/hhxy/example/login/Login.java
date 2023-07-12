package com.hhxy.example.login;

import com.hhxy.example.weightRandomName.WeightBeen;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 将正确的用户名和密码保存至本地文件中userinfo.txt
 * 格式: username=zhangsan&password=111
 * 需求:
 * 用户键盘录入用户名和密码,于文件中的用户名密码进行对照,看看是否一致
 * 如果一致,则显示登录成功.
 * 否则,登录失败.
 */
public class Login {
    public static void main(String[] args) throws IOException {
        ArrayList<User> users = readFile();
        Scanner sc=new Scanner(System.in);
        System.out.println("用户名:");
        String username = sc.next();
        System.out.println("密码:");
        String password = sc.next();
        loginFile(users,username,password);
    }

    //定义一个方法,判断是否登录成功
    public static void loginFile(ArrayList<User> list,String username,String password){
        //获取用户名
        for (User user : list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) ){
                System.out.println("登录成功");
                return;
            }
        }
        System.out.println("登录失败");
    }

    public static ArrayList<User> readFile() throws IOException {
        //定义一个集合存储WeightBeen对象
        ArrayList<User> list = new ArrayList<>();
        //读取数据
        BufferedReader br =new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\userinfo.txt"));
        //按行进行读取
        String line;
        while ((line=br.readLine())!=null) {
            String[] split = line.split("&");
            String[] username = split[0].split("=");
            String[] password = split[1].split("=");
            //实例化javabeen对象(注意一定要放在循环内,原因每一个人都需要new出一个对象进行存储)
            User user=new User();
            user.setUsername(username[1]);
            user.setPassword(password[1]);
            //并将切割后的数据,放入到User对象中,在将对象放入到集合中.
            list.add(user);
        }
        System.out.println(list);
        //调用权重随机方法
        br.close();
        return list;
    }

    //
    public static void writerFile(ArrayList<WeightBeen> list) throws IOException {
        //应当将次数写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\userinfo.txt"));
        for (WeightBeen s : list) {
            //调用重写的toString方法
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
