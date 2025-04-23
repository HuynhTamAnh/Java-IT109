package main.ra.edu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(Date date) {
        if (date == null) return "";
        return DATE_FORMAT.format(date);
    }

    public static Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày! Sử dụng dd/MM/yyyy");
            return new Date(); // Trả về ngày hiện tại nếu parse lỗi
        }
    }

    public static String formatBoolean(boolean value) {
        return value ? "Yes" : "No";
    }
}