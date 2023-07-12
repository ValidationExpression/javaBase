package com.hhxy.example.craw;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.*;
import java.util.*;

/**
 * 使用hutool工具包进行爬取数据,(姓氏,男女名),拼接为姓名
 */
public class CrawDemo01 {
    public static void main(String[] args) throws IOException {
        //网址姓:https://hanyu.baidu.com/shici/detail/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
        //男名: http://www.haoming8.cn/baobao/10881.html
        //女名: http://www.haoming8.cn/baobao/7641.html

        String familyName = "https://hanyu.baidu.com/shici/detail/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boy = "http://www.haoming8.cn/baobao/10881.html";
        String gail = "http://www.haoming8.cn/baobao/7641.html";
        //获取网页的数据
        HashSet<String> context = getWebContext(familyName, boy, gail);
        //创建txt文件
        toFile(context);

    }

    //将数据存储到文件中
    public static void toFile(HashSet<String> str) throws IOException {
        //BufferedOutputStream,文件类型进行转换
        String filePath="D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\name.txt";
        FileWriter fwriter = new FileWriter(filePath, true);
        for (String s : str) {
            fwriter.write(s+"\n");
        }
        fwriter.flush();
        fwriter.close();
    }

    //定义一个网页爬取的方法
    public static HashSet<String> getWebContext (String familyName,String boy,String gail){
        //使用hutool工具获取网页数据
        String listContentFamily = HttpUtil.get(familyName);
        String listContentBoy = HttpUtil.get(boy);
        String listContentGail = HttpUtil.get(gail);
        //使用正则获取姓名
        List<String> familyNameNet = ReUtil.findAll("(.{4})(，|。)", listContentFamily, 1);
        List<String> boyNameNet = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(、|。)", listContentBoy, 1);
        List<String> gailNameNet = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})( )", listContentGail, 1);
        //将姓数组进行变换,原形式为 ---赵钱孙李
        ArrayList<String> fName=new ArrayList<>();
        for (String s : familyNameNet) {
            //将--赵钱孙李--分为-赵,钱,孙,李  形式
            for (int i = 0; i < s.length(); i++) {
                fName.add(String.valueOf(s.charAt(i)));
            }
        }
        //调用组成姓名的方法
        return combinationName(fName,boyNameNet,gailNameNet);
    }

    //将姓氏和男女的名进行匹配,得到对应的姓名,形式为: 刘备-男-23 (其中姓名随机产生)
    public static HashSet<String> combinationName(ArrayList<String> fName,List<String> boyNameNet,List<String> gailNameNet){
        //的出的姓名不能重复,所以使用HashSet进行存储,避免了重复的可能
        HashSet<String> hs = new HashSet<>();
        Random r = new Random();
        //男生姓名(生成30个)
        for (int i = 0; i < 30; i++) {
            //对数组进行打乱操作, 方法有Random, shuffle
            Collections.shuffle(fName);
            Collections.shuffle(boyNameNet);
            //产生随机年龄
            int age = r.nextInt(10)+18;
            hs.add(fName.get(0)+boyNameNet.get(0)+"-"+"男"+"-"+age);
        }

        //女生姓名(生成30个)
        for (int i = 0; i < 30; i++) {
            Collections.shuffle(fName);
            Collections.shuffle(gailNameNet);
            int age = r.nextInt(10)+15;
            hs.add(fName.get(0)+gailNameNet.get(0)+"-"+"女"+"-"+age);
        }
        return hs;
    }
}

