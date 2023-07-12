package com.hhxy.example.weightRandomName;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现需求:
 * 使用权重的方式,进行随机获取名字,
 * 解释: 当一个名字被选中后,再一次选中这个名字的概率会减少.
 * 使用权重例如: 离绣盈-女-23-1
 * 当第一次点中:离绣盈后,这个同学的权重会变为原来的1/2,  ---离绣盈-女-23-0.5
 * ---------------------
 * 如何计算权重:
 * 一个同学的权重 / 所有同学的权重的和 = 的出一个区间范围,如图 image/img.png
 * 会产生一个范围,此时使用Math.Random()产生一个随机数,根据随机数的大小,来确定在那个区间,进而找到对应的同学.
 */
public class WrightName {
    public static void main(String[] args) throws IOException {
        //调用读取文件的方法
        readFile();
    }
    //读取数据
    public static void readFile() throws IOException {
        //定义一个集合存储WeightBeen对象
        ArrayList<WeightBeen> list = new ArrayList<>();
        //读取数据
        BufferedReader br =new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\weight.txt"));
        //按行进行读取
        String line;
        while ((line=br.readLine())!=null) {
            //对数据按需求进行切割"-"
            String[] split = line.split("-");
            //实例化javabeen对象(注意一定要放在循环内,原因每一个人都需要new出一个对象进行存储)
            WeightBeen weightBeen = new WeightBeen();
            //并将切割后的数据,放入到WeightBeen对象中,在将对象放入到集合中.
            weightBeen.setName(split[0]);
            weightBeen.setSex(split[1]);
            weightBeen.setAge(Integer.parseInt(split[2]));
            weightBeen.setWeight(Double.parseDouble(split[3]));
            list.add(weightBeen);
        }
        //调用权重随机方法
        weightRandom(list);
        br.close();
    }

    //定义一个权重随机的方法
    public static void weightRandom(ArrayList<WeightBeen> list) throws IOException {
        //1.计算所有权重的和
        double sumWeight=0;
        //遍历集合
        for (WeightBeen weight : list) {
            sumWeight = sumWeight+weight.getWeight();
        }
        //System.out.println(sumWeight);
        //2.得出对应的权重范围(0.1,0.2,0.3,0.4,0.5, ... 0.9,1.0)得出规律,下一个人的权重是上个人权重+0.1
        //定义一个数组用于存储权重值
        double[] arr=new double[list.size()];
        //定义一个索引
        int index=0;
        double rangeWeight=0;
        for (WeightBeen been : list) {
            rangeWeight = rangeWeight+ been.getWeight()/sumWeight;
            arr[index] = rangeWeight;
            index++;
        }
       // System.out.println(Arrays.toString(arr));
        //3.随机产生一个权重区间值
        double random = Math.random();//(0~1)
        //4.使用二分查找的到对应的区间的索引(返回的位置是 -插入点 -1),
        //所以为了的出正确的值应当进行变换
        int index2 = -Arrays.binarySearch(arr, random)-1;
        //5.的出索引对应的同学
        WeightBeen student = list.get(index2);
        //6.当点中这个学生后,他下一次点中的权重变为原1/2
        student.setWeight(student.getWeight()/2);
        //调用写入方法
        writerFile(list);
    }

    //将权重变化后的数在写入到原文件
    public static void writerFile(ArrayList<WeightBeen> list) throws IOException {
        //应当将次数写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\weight.txt"));
        for (WeightBeen s : list) {
            //调用重写的toString方法
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
