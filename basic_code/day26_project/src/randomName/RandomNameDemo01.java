package randomName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 也是随机点名
 * 但是条件: 70% 点中男生
 *          30% 点中女生
 */
public class RandomNameDemo01 {
    public static void main(String[] args) throws IOException {
        //读取文件,需要按行进行读取,所以此时应当使用(字符缓冲流)
        BufferedReader bfReader=new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\name.txt"));
        //定义男生集合用于存储读出的数据
        ArrayList<String> boyList=new ArrayList<>();
        //定义男生集合用于存储读出的数据
        ArrayList<String> gailList=new ArrayList<>();
        //按行进行读取数据
        String line;
        while ((line=bfReader.readLine())!=null){
            //对读出的数据进行截取,只保留名字
            String[] split = line.split("-");
            //进行判断是男生还是女生
            if (split[1].equals("男")){
                boyList.add(split[0]);
            } else{
                gailList.add(split[0]);
            }
        }
        //概率问题可以转化为,使用一个数组存储1-10共10个数,然后随机抽取1-7为男生,8-10为女生.
        int[] a ={1,2,3,4,5,6,7,8,9,10};
        Random r=new Random();
        int index = r.nextInt(10);
        //进行if判断
        //对数组进行打乱操作(方法有2,使用Random, Collections.shuffle(list);)
        if (a[index] <=7){
            //打乱数组,只取第一个
            Collections.shuffle(boyList);
            System.out.println(boyList.get(0));
        }else {
            Collections.shuffle(gailList);
            System.out.println(gailList.get(0));
        }
        bfReader.close();
    }
}
