package com.example;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 根据文件的后缀名,查找其中的个数
 * 一个文件夹a中有多种文件例如
 * a.txt
 * c.class
 * a.mp4
 * ...
 * 计算相同类型文件的个数
 *
 * 使用的方法:<键,值>形式进行存储
 */
public class Demo05 {
    public static void main(String[] args) {

        File file=new File("D:\\a");
        System.out.println(getCount(file));

    }

    public static HashMap<String,Integer> getCount(File file){
        //1.使用键:进行存储文件格式,值:数量
        HashMap<String,Integer> hm=new HashMap<>();
        //1.找到D盘下的所有文件或文件夹
        File[] files = file.listFiles();
        //在不同的目录可能会存在权限问题,因此在这里进行判断
        if (files != null) {
            //2.增强for遍历
            for (File file1 : files) {
                //3.判断文件是文件夹还是文件
                if (file1.isFile()){
                    String name = file1.getName();
                    //切割字符串
                    String[] split = name.split("\\.");
                    //会按照.进行切分,得到一个数组
                    for (String s : split) {
                        System.out.println(s);
                    }
                    //由于文件可能为a.a.txt类型
                    if (split.length>=2){
                        //获取后缀
                        String endString = split[split.length - 1];
                        //含有
                        if (hm.containsKey(endString)){
                            //如果集合中包含,此文件类型,则数量增加
                            int count = hm.get(endString);
                            count++;
                            //在将数量递增结果放入,集合
                            hm.put(endString,count);
                        }else {
                            //不含,将其添加进去
                            hm.put(endString,1);
                        }
                    }
                }else {
                    //4.如果是文件夹则进行递归遍历
                    HashMap<String, Integer> sunMap = getCount(file1);
                    //获取其中的键与值,在于原集合的数量进行相加
                    Set<Map.Entry<String, Integer>> entries = sunMap.entrySet();
                    //获取其中的键,值
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        //判断是否已经存在
                        if (hm.containsKey(key)){
                            //获取原key的值
                            int count = hm.get(key);
                            count=count+value;
                            hm.put(key,count);
                        }else{
                            //不存在的时候
                            hm.put(key,value);
                        }

                    }

                }
            }
        }
        return hm;
    }
}
