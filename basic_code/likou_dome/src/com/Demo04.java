package com;

/**
 * 判断两个圆是否相切
 */
public class Demo04 {
    public static void main(String[] args) {

        //实例化圆
        Circle1 circle1=new Circle1(10,10, 20);
        Circle2 circle2=new Circle2(10,10,20);
        circle(circle1,circle2);
    }
    //判读是否相切
    public static void circle(Circle1 circle1,Circle2 circle2){
        //实现原理:两个圆点的距离>两个圆的半径之和 ,相切
        //1.计算两个圆的半径之和
        int rSum=circle1.r1+ circle2.r2;
        //2.计算圆点距离
        double nu =Math.sqrt((circle1.x1-circle2.x2)*(circle1.x1-circle2.x2)+(circle1.y1- circle2.y2)*(circle1.y1- circle2.y2));
        if (rSum<nu){
            System.out.println("相离");
        }else {
            System.out.println("相交");
        }
    }
}

class Circle1{
    public int r1;
    public int x1;
    public int y1;
    public Circle1(int r1, int x1, int y1) {
        this.r1 = r1;
        this.x1 = x1;
        this.y1 = y1;
    }
}

class Circle2{
    public int r2;
    public int x2;
    public int y2;
    public Circle2(int r2, int x2, int y2) {
        this.r2 = r2;
        this.x2 = x2;
        this.y2 = y2;
    }
}
