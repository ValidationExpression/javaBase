package com.example;

public class Game {
    public static void main(String[] args) {
        Role r1 = new Role("汤姆", 100);
        Role r2 = new Role("杰瑞", 100);
        //不知道要攻击多少次
        while (true) {
            r1.stack(r2);
            if (r2.getBlood() == 0) {
                System.out.println(r2.getName() + "game over");
                break;
            }
            //回合制
            r2.stack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r1.getName() + "game over");
                break;
            }

        }
    }
}
