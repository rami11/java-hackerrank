package learnjava.easy.list;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("input2.txt"))) {
            int n = scan.nextInt();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                list.add(scan.nextInt());
            }

            int q = scan.nextInt();
            while (q-- > 0) {
                String query = scan.next();
                int x, y;
                if (query.equalsIgnoreCase("Insert")) {
                    x = scan.nextInt();
                    y = scan.nextInt();
                    insert(list, x, y);
                } else if (query.equalsIgnoreCase("Delete")) {
                    x = scan.nextInt();
                    delete(list, x);
                } else {
                    System.err.println("Unknown operation!");
                }
            }
            list.forEach(num -> System.out.print(num + " "));

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void insert(List<Integer> list, int x, int y) {
        if (x < list.size()) {
            list.add(x, y);
        } else {
            list.add(y);
        }
    }

    private static void delete(List<Integer> list, int x) {
        if (x < list.size()) {
            list.remove(x);
        }
    }
}
