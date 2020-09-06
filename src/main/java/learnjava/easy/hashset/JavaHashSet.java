package learnjava.easy.hashset;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new FileReader("input2.txt"))) {
            int t = s.nextInt();
            String[] pair_left = new String[t];
            String[] pair_right = new String[t];

            for (int i = 0; i < t; i++) {
                pair_left[i] = s.next();
                pair_right[i] = s.next();
            }

            Set<String> set = new HashSet<>();
            for (int i = 0; i < t; i++) {
                String pair = String.join(", ", pair_left[i], pair_right[i]);
                set.add(pair);
                System.out.println(set.size());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
