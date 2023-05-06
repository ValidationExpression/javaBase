package com.example.text02;

public class GirlFriendMain {
    /**
     * 实现四个人,求年龄平均值,和小于平均年龄的人的信息,个数
     * @param args
     */
    public static void main(String[] args) {
        GirlFriend[] girlFriend = new GirlFriend[4];

        //实例化类
        GirlFriend girl1 = new GirlFriend("1", 18, "读书");
        GirlFriend girl2 = new GirlFriend("2", 21, "听音乐");
        GirlFriend girl3 = new GirlFriend("3", 22, "运动");
        GirlFriend girl4 = new GirlFriend("4", 23, "电影");
        girlFriend[0] = girl1;
        girlFriend[1] = girl2;
        girlFriend[2] = girl3;
        girlFriend[3] = girl4;

        //定义一个遍历用于存储年龄
        int num = 0;
        for (int i = 0; i < girlFriend.length; i++) {
            GirlFriend girl = girlFriend[i];
            num = num + girl.getAge();
        }
        int average = num / girlFriend.length;
        System.out.println("平均年龄:" + average);

        //定义一个数量变量
        int count = 0;
        for (int i = 0; i < girlFriend.length; i++) {
            GirlFriend girl = girlFriend[i];
            if (girl.getAge() < average) {
                System.out.println(girl.getName() + "," + girl.getAge() + "," + girl.getHobby());
                count++;
            }
        }
        System.out.println(count);

    }
}
