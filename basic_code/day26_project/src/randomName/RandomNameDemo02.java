package randomName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 随机从文件中点名
 * 要求: 第三次必定是: 离绣盈
 */
public class RandomNameDemo02 {
    public static void main(String[] args) throws IOException {
        numberDemo();
    }

    //实现随机点名
    public static void randomName() throws IOException {
        //读取文件,需要按行进行读取,所以此时应当使用(字符缓冲流)
        BufferedReader bfReader=new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\name.txt"));
        //定义一个集合用于存储读出的数据
        ArrayList<String> list=new ArrayList<>();
        //按行进行读取数据
        String line;
        while ((line=bfReader.readLine())!=null){
            //对读出的数据进行截取,只保留名字
            String[] split = line.split("-");
            list.add(split[0]);
        }
        //对数组进行打乱操作(方法有2,使用Random, Collections.shuffle(list);)
        Collections.shuffle(list);
        System.out.println(list.get(0));
        bfReader.close();
    }


    //用于判断此时运行了几次
    public static void numberDemo() throws IOException {
        //思路: 每一次运行都需要修改文件,所以不能让变量在内存中,应当放在文件中
        //且读取文件应当按一行进行读取,所以使用BufferedReader
        BufferedReader br =new BufferedReader(new FileReader("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\a.txt"));
        //按行进行读取
        String line = br.readLine();
        br.close();
        //类型转换
        int count = Integer.parseInt(line);
        //计数器
        count++;
        //判读
        if (count<3){
            randomName();
        }else if (count==3){
            System.out.println("离绣盈");
        }else {
            randomName();
        }
        //应当将次数写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\ITData\\idea_data\\basic_code\\day26_project\\file\\a.txt"));
        bw.write(count+""); //注意一定要加一个"",原因:write在写入文件的时候,会使用ASCLL表进行对比
        bw.newLine();
        bw.close();
    }
}
