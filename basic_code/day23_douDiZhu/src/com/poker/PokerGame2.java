package com.poker;

import java.util.*;

/**
 * 改进:为了可以判断出牌的大小,(但由于牌是字符,且顺序不可是混乱的),所以此时引入Map集合进行操作
 * 根据Map中的键值(提前建立对应关系)的大小来判断大小.
 */
public class PokerGame2 {

    static HashMap<Integer,String> hm=new HashMap<>();
    //建立一个数组存储键值,并使其作为发牌的前提,玩家会根据得到的键进行匹配对应的值,进而的出牌
    static ArrayList<Integer> list=new ArrayList<>();

    static {
        //准备牌
        String[] color = {"♥", "♣", "♠", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //将牌放入集合
        //定义行键
        int key=1;
        for (String n : number) {  //先遍历数字的原因是为了,可以使用键值来判断其值的大小.
            for (String c : color) {
                hm.put(key,c+n);
                //添加行键到数组
                list.add(key);
                //键值增加
                key++;
            }
        }
        //添加大小王
        hm.put(key,"小王");
        list.add(key);
        key++;
        hm.put(key,"大王");
        list.add(key);

        System.out.println(hm);
    }

    public PokerGame2(){
        //2.一个牌盒用于装所有的牌(并进行打乱)
        Collections.shuffle(list);
        System.out.println(list);
        //3.创建三个用户(数组),还有底牌(数组存储)
        TreeMap<Integer,String> load=new TreeMap<>(); //底牌
        TreeMap<Integer,String> player1=new TreeMap<>(); //玩家
        TreeMap<Integer,String> player2=new TreeMap<>(); //玩家
        TreeMap<Integer,String> player3=new TreeMap<>(); //玩家
        //3.将牌分发给玩家(后三张牌为底牌)由于此时需要下标(所以使用普通循环)
        for (int i = 0; i < list.size(); i++) {
            //根据索引获取值
            Integer key=list.get(i);
            if (i>=list.size()-3){
                load.put(key,hm.get(key));
            }else if (i%3==0){ //i%3会有三种结果:0,1,2分别代表三个玩家
                player1.put(key,hm.get(key));
            } else if (i%3==1) {
                player2.put(key,hm.get(key));
            }else {
                player3.put(key,hm.get(key));
            }
        }

        //遍历玩家数组/底牌
        lookPoker("底牌",load);
        lookPoker("1",player1);
        lookPoker("2",player2);
        lookPoker("3",player3);
    }
    //定义一个方法用于遍历数组
    public void lookPoker(String name,TreeMap<Integer,String> tm){
        System.out.print(name+":");
        System.out.print(tm.values());
        System.out.println();
    }
}
