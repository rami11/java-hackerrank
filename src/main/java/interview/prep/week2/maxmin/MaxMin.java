package interview.prep.week2.maxmin;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxMin {

    private static final Path WORKING_DIR = Paths.get("src", "main", "java", "interview", "prep", "week2", "maxmin");

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(WORKING_DIR.resolve(Paths.get("testcase16.txt")));

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> arr = Stream.generate(scanner::nextInt).limit(n).collect(Collectors.toList());

        int result = maxMin(k , arr);
        System.out.println(result);
    }

    public static int maxMin(int k, List<Integer> arr) {

        if (arr == null || arr.isEmpty()) {
            return 0;
        }

        Collections.sort(arr);

        return IntStream.rangeClosed(0, arr.size() - k)
                .map(i -> arr.get(i + k - 1) - arr.get(i))
                .min()
                .orElse(0);
    }
}
