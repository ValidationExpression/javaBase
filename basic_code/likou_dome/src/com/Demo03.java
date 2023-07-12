package com;

/**
 * 需求:
 * 判断1. 如何判断两个矩形是否相交？相切？相离？
 */
public class Demo03 {
    public static void main(String[] args) {
        //设计思路:使用逆向思维
        //条件:只要两个矩形不相交
        //实例化两个矩形类
        Rectangle01 rectangle01=new Rectangle01(10,10,10,10);
        Rectangle02 rectangle02=new Rectangle02(25,25,20,20);
        rectangle(rectangle01,rectangle02);

    }
    //定义一个方法用于判断两个矩形的距离
    public static void rectangle(Rectangle01 rectangle01,Rectangle02 rectangle02){
        //1.矩形2的左x坐标大于矩形1的最大坐标(x1+w1)
        int r1 = rectangle01.x01+ rectangle01.w01;
        boolean right = rectangle02.x02>r1;
        //2.矩形2的左x最大坐标(x2+w2)小于矩形1的x1
        int l2 = rectangle02.x02+rectangle02.w02;
        boolean left = rectangle01.x01 > l2;
        //3.矩形2的左y坐标大于矩形1的最大坐标(y1+h1)
        int o1=rectangle01.y01+rectangle01.h01;
        boolean on = rectangle02.y02>o1;
        //4.矩形2的左y最大坐标(y2+h2)小于矩形1的坐标y1
        int u2=rectangle02.y02+rectangle02.h02;
        boolean up= u2< rectangle01.y01;

        //四个条件只要一个满足即可
        if (right || left || on || up){
            System.out.println("不相交");
        }else {
            System.out.println("相交");
        }
    }
}

//定义矩形1
class Rectangle01{
    public int h01; //高
    public int w01; //宽
    public int x01; //左x坐标
    public int y01; //左y坐标
    public Rectangle01(int x01,int y01,int h01,int w01){
        this.x01=x01;
        this.y01=y01;
        this.h01=h01;
        this.w01=w01;
    }
}
//定义第二个矩形
class Rectangle02{
    public int h02;
    public int w02;
    public int x02;
    public int y02;
    public Rectangle02(int x02,int y02,int h02,int w02){
        this.x02=x02;
        this.y02=y02;
        this.h02=h02;
        this.w02=w02;
    }
}

