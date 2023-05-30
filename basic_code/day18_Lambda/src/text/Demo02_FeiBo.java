package text;

/**
 * 需求:斐波那契数列运用(使用递归方法)
 */
public class Demo02_FeiBo {
    public static void main(String[] args) {

        System.out.println(getSum(12));
    }
    public static int getSum(int month){
        if (month==1 || month==2){
            return 1;
        }
        return getSum(month-1)+getSum(month-2);
    }
}
