package wh.practice.algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author wanghuan
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Date from = Date.from(todayStart.toInstant(ZoneOffset.of("+8")));
        System.out.println(from.getTime());
    }
}
