package learnjava.easy.map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input2.txt"));
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> nameToPhone = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            nameToPhone.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(nameToPhone.containsKey(s) ? s + "=" + nameToPhone.get(s) : "Not found");
          /*  if (in.hasNext()) {
                System.out.println();
            }*/
        }
    }
}
