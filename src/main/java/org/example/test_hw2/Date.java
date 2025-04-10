package org.example.test_hw2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    public static String tostring() {
        // دریافت تاریخ و زمان فعلی
        LocalDateTime now = LocalDateTime.now();

        // فرمت کردن تاریخ و زمان به رشته
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // نمایش نتیجه
        return(formattedDateTime);
    }
}
