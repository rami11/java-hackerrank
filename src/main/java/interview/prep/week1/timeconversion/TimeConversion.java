package interview.prep.week1.timeconversion;

public class TimeConversion {

    public static void main(String[] args) {
        String result = timeConversion("06:40:03AM");
        System.out.println(result);
    }

    public static String timeConversion(String s) {

        int hour = Integer.parseInt(s.substring(0, 2));
        String amPm = s.substring(8);

        String hh;
        if (hour == 12) {
            hh = String.format("%02d", amPm.equalsIgnoreCase("PM") ? hour : 0);
        } else {
            hh = String.format("%02d", amPm.equalsIgnoreCase("PM") ? hour + 12 : hour);
        }

        return hh + s.substring(2, 8);

    }

}