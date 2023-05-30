package text;

/**
 * 猴子吃桃:一堆桃子,猴子第一天吃了其中的一半,并且多吃一个,以后的每一天猴子都吃剩下的一半,然后多吃一个
 *          在第10天的时候(还没吃),现在只剩下一个,问起始有多少桃子.
 */
public class Demo01_TaoZi {
    public static void main(String[] args) {
        System.out.println(getSum(1));
    }
    //使用递归
    public static int getSum(int number){
        if (number<0 || number>10){
            return -1;
        }
        if (number==10){
            return 1;
        }
        return (getSum(number+1)+1)*2;
    }
}
