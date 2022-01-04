package interview.prep.week3.simpletexteditor;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(Paths.get("src",
                "main",
                "java",
                "interview",
                "prep",
                "day6",
                "simpletexteditor",
                "input07.txt"));
        int q = scanner.nextInt();
        Editor editor = new Editor();

        while (q-- > 0) {

            try {
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        String stringToAppend = scanner.next();
                        editor.append(stringToAppend);
                        break;
                    case 2:
                        int k = scanner.nextInt();
                        editor.delete(k);
                        break;
                    case 3:
                        int index = scanner.nextInt();
                        editor.print(index);
                        break;
                    case 4:
                        editor.undoLastOperation();
                        break;
                    default:
                        throw new Exception("Unknown operation");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
