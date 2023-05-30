package scannerText;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 需求:键盘录入1~100之间的整数并添加到集合中,当集合中的数据超过200停止录入.
 */

public class ScannerDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //定义一个集合存储数据
        ArrayList num = new ArrayList();
        //定义的集合可以为
        //ArrayList<Integer> num = new ArrayList();
        while (true){
            System.out.println("请输入1~100之间的整数");
            String s = sc.nextLine();
            num.add(s);
            //调用方法判断是否和大于200
            if (sum(num)){
                break;
            }

        }
    }
    //定义一个方法用于判断集合中的数据和
    public static boolean sum(ArrayList num){
        int number=0;
        for (int i = 0; i < num.size(); i++) {
            String t = (String) num.get(i);
            //由于数组中的数据为String 类型需要使用包装类进行强转
            int integer = Integer.parseInt(t);
            number = integer+number;
            if (number>200){
                return true;
            }
        }
        return false;
    }
}
