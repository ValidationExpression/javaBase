package text;

/**
 * 爬楼梯:可以一次爬一阶,或2阶,3阶三种爬法,
 *      问若有20阶台阶有多少中爬法
 */
public class Demo01_LouTi {
    public static void main(String[] args) {
        System.out.println(getCount(20));
    }

    public static int getCount(int num){
        //两种爬法与其不同
//        if (month==1 || month==2){
//            return 1;
//        }
        //注意若是三种爬法在最后17,18,19时会产生不同的次数
        if (num==1 || num==2){
            return num;
        }else if (num==3){
            return 4;
        }else {
            return getCount(num-1)+getCount(num-2)+getCount(num-3);
        }
    }
}
