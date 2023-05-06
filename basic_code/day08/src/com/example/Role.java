package com.example;

import java.util.Random;

public class Role {
    private String name;
    //人物血量
    private int blood;

    //定义构造方法
    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    //定义一个攻击的方法-
    //有攻击就应该有攻击者与被攻击者
    //方法体内的为被攻击者
    public void stack(Role role) {

        //使用随机数来产生伤害值
        Random ra = new Random();
        int hurt = 0;
        //攻击类型
        String stacks = null;
        //随机攻击
        int st = ra.nextInt(3);
        switch (st) {
            case 0:
                stacks = "突刺";
                hurt = ra.nextInt(20) + 1;
                break;
            case 1:
                stacks = "普通攻击";
                hurt = ra.nextInt(6) + 1;
                break;
            case 2:
                stacks = "上挑";
                hurt = ra.nextInt(10) + 1;
                break;
        }

        //剩余血量
        int remainBlood = role.getBlood() - hurt;
        //防止产生负数血量(使用三目运算符当为负数时,多变为0)
        remainBlood = remainBlood < 0 ? 0 : remainBlood;
        //修改受伤人的血量(如果不进行修改受伤者的血量)由于第一次初始化时两人的血量都是100,
        // 此时getBlood()获取的血量一直是100,进而导致剩余血量一直大于0导致循环不会跳出.
        role.setBlood(remainBlood);

        System.out.println(this.name + "使用" + stacks + "对," + role.getName() + "造成了" + hurt + "伤害.剩余" + remainBlood + "血量.");
    }
}
