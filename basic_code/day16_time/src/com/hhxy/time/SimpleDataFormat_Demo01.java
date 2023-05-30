package com.hhxy.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 需求:确定某一个时间是否在一个区间内
 * 例子:开始时间-2023年11月11日 0:0:0
 *      结束时间-2023年11月11日 0:10:0
 *      测试时间
 *      2023年11年11日 0:01:0
 */
public class SimpleDataFormat_Demo01 {
    public static void main(String[] args) throws ParseException {
        //定义三个字符串
        String startStr="2023年11月11日 0:0:0";
        String endStr="2023年11月11日 0:10:0";
        String str="2023年11月11日 0:11:0";
        //解析时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date start = sdf.parse(startStr);
        Date end = sdf.parse(endStr);
        Date strData = sdf.parse(str);

        //只有换算为毫秒才可以进行比较
        long startTime = start.getTime();
        long endTime = end.getTime();
        long strTime = strData.getTime();
        //判断
        if (strTime>=startTime && strTime<=endTime){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
