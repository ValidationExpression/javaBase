package randomName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 从文件name.txt中随机进行点名,只显示姓名
 */
public class RandomNameDemo {
    public static void main(String[] args) throws IOException {
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
}
