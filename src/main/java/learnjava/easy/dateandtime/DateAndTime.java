package learnjava.easy.dateandtime;

import java.io.*;
import java.time.LocalDate;
import java.util.Calendar;

public class DateAndTime {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int month = Integer.parseInt(firstMultipleInput[0]);

            int day = Integer.parseInt(firstMultipleInput[1]);

            int year = Integer.parseInt(firstMultipleInput[2]);

            String res = findDay1(month, day, year);

            bufferedWriter.write(res);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().name();
    }

    public static String findDay1(int month, int day, int year) {
        String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday" };

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        return strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1].toUpperCase();
    }

}
