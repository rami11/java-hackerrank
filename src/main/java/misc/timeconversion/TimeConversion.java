package misc.timeconversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeConversion {

    public static void main(String[] args) {
        // Naive way
        System.out.println(timeConversion("12:05:45PM"));
        System.out.println(timeConversion("06:40:03AM"));

        System.out.println();

        // with local date
        System.out.println(timeConversion1("12:05:45AM"));
        System.out.println(timeConversion1("06:40:03AM"));

        System.out.println();

        // with date
        System.out.println(timeConversion2("12:05:45AM"));
        System.out.println(timeConversion2("06:40:03AM"));
    }

    private static String timeConversion(String s) {
        String result = "";
        String[] hours = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

        String pmam = s.substring(8);
        if (pmam.equals("PM")) {
            if (!s.substring(0, 2).equals("12")) {
                result = hours[Integer.valueOf(s.substring(0, 2)) - 1];
            } else {
                result = s.substring(0, 2);
            }
        } else if (pmam.equals("AM")) {
            if (!s.substring(0, 2).equals("12")) {
                result = s.substring(0, 2);
            } else {
                result = "00";
            }
        }
        result += s.substring(2, 8);
        return result;
    }

    private static String timeConversion1(String s) {
        LocalTime localTime = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private static String timeConversion2(String s) {
        try {
            Date date = new SimpleDateFormat("hh:mm:ssa").parse(s);
            return new SimpleDateFormat("HH:mm:ss").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
