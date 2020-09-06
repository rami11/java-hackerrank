package interview.warmup.repeatedstring;

public class RepeatedString {

    public long repeatedString(String s, long n) {
        if (s.length() == 1 && s.equals("a")) {
            return n;
        }
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        long reps =  n / s.length();
        count *= reps;

        long excess = n % s.length();
        String excessStr = s.substring(0, (int) excess);
        for (int i = 0; i < excess; i++) {
            if (excessStr.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }
}
