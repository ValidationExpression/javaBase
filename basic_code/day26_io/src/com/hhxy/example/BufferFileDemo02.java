package com.hhxy.example;

import java.io.*;

public class BufferFileDemo02 {
    public static void main(String[] args) throws IOException {
        /**
         * 需求:一个程序有三次免费使用机会,请判断超过三次的时候会提示,免费次数耗尽.
         */
        //思路: 每一次运行都需要修改文件,所以不能让变量在内存中,应当放在文件中
        //且读取文件应当按一行进行读取,所以使用BufferedReader
        BufferedReader br =new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_io\\a.txt"));
        //按行进行读取
        String line = br.readLine();
        br.close();
        //类型转换
        int count = Integer.parseInt(line);
        //计数器
        count++;
        //判读
        if (count<=3){
            System.out.println("还有"+(3-count)+"次机会");
        }else {
            System.out.println("没有免费次数了");
        }
        //应当将次数写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\ITData\\idea_data\\basic_code\\day26_io\\a.txt"));
        bw.write(count+""); //注意一定要加一个"",原因:write在写入文件的时候,会使用ASCLL表进行对比
        bw.newLine();
        bw.close();
    }
}
