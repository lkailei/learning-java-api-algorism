package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class DateUtilsTest {
    public static void main(String[] args) {
        // 在指定的日期添加指点的天数
        Date date = DateUtils.addDays(new Date(), 10);
        System.out.println(date);
        Date date1 = DateUtils.addMonths(new Date(), 2);
        System.out.println(date1);
    }
}
