package learnjava.easy.staticinitializerblock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StaticInitializerBlock {
    private static boolean flag;
    private static int B, H;

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader("case2.txt"))) {
            flag = true;
            B = Integer.parseInt(reader.readLine().trim());
            H = Integer.parseInt(reader.readLine().trim());
            if (B <= 0 || H <= 0) {
                throw new Exception("Breadth and height must be positive");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            flag = false;
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }
}
