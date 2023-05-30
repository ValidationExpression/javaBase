package text;

import java.util.Arrays;

/**
 * 需求:斐波那契数列运用
 */
public class Demo01_FeiBo {
    public static void main(String[] args) {
        int[] arr=new int[12];
        //定义前两个数
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
    }
}
