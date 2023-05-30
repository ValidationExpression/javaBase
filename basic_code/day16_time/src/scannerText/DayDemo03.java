package scannerText;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 计算你活了多少天
 */
public class DayDemo03 {
    public static void main(String[] args) {
        //JDK8
        LocalDate s1 = LocalDate.of(2000,4,1);
        LocalDate s2 = LocalDate.now();
        long between = ChronoUnit.DAYS.between(s1, s2);
        System.out.println(between);

    }
}
