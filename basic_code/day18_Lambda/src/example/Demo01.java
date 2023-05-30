package example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 需求:
 * 定义一个数组,存储一些人的的对象,利用Array,sort方法进行排序
 * 要求1.属性有:姓名,年龄,身高
 * 要求2.按照年龄进行排序,如果年龄一样按照身高排序,身高一样按照姓名字母进行排序
 */
public class Demo01 {
    public static void main(String[] args) {

        //1.创建三个类
        People people1 = new People("xiaoming", 18, 1.66);
        People people2 = new People("xiaomingl", 19, 1.56);
        People people3 = new People("xiao", 18, 1.68);
        //定义数组存储信息
        People[] arr = {people1, people2, people3};
        //
        Arrays.sort(arr, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                //排序要求
                double temp = o1.getAge() - o2.getAge();
                //三元运算符
                temp = temp == 0 ? o1.getHigh() - o2.getHigh() : temp;
                //a.compareTo(b)含义对a,b两个字符串进行比较,测试结果在Text类中(结论:按照ascol码表所对应的数进行做差运算,得出的结果为整数)
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                //根据所返回的结果进行不同的排序:
                if (temp > 0) {
                    return 1;
                } else if (temp < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
