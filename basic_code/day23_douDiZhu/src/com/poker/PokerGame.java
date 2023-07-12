package com.poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 创建空参构造,用于实现游戏的功能的类
 *
 *
 * 实现:产生牌,并进行发牌(控制台实现)
 */
public class PokerGame {

    //由于定义的为静态牌且方法体还需要使用数组所有应当定义在外面
    //定义一个数组用于存储合并后的牌
    static ArrayList<String> list=new ArrayList<>();
    //1.创建牌(位于方法体外的原因是:每一次运行构造方法时不会重新创建牌)
    static {
        //准备牌
        String[] color={"♥","♣","♠","♦"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //将花色和数字进行合并(♥3)
        for (String c : color) {
            for (String n : number) {
                list.add(c+n);
            }
        }
        //大小王
        list.add("大王");
        list.add("小王");
    }

    public PokerGame(){
        //2.一个牌盒用于装所有的牌(并进行打乱)
        Collections.shuffle(list);
        System.out.println(list);
        //3.创建三个用户(数组),还有底牌(数组存储)
        ArrayList<String> load=new ArrayList<>(); //底牌
        ArrayList<String> player1=new ArrayList<>(); //玩家
        ArrayList<String> player2=new ArrayList<>(); //玩家
        ArrayList<String> player3=new ArrayList<>(); //玩家
        //3.将牌分发给玩家(后三张牌为底牌)由于此时需要下标(所以使用普通循环)
        for (int i = 0; i < list.size(); i++) {
            //根据索引获取值
            String a=list.get(i);
            if (i>=list.size()-3){
                load.add(a);
            }else if (i%3==0){ //i%3会有三种结果:0,1,2分别代表三个玩家
                player1.add(a);
            } else if (i%3==1) {
                player2.add(a);
            }else {
                player3.add(a);
            }
        }

        //遍历玩家数组/底牌
        lookPoker("底牌",load);
        lookPoker("1",player1);
        lookPoker("2",player2);
        lookPoker("3",player3);

    }

    //定义一个方法用于遍历数组
    public void lookPoker(String name,ArrayList<String> list){
        System.out.print(name+":");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
