package learnjava.medium.onedarray.two;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class OneDArray2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("input5.txt"))) {

            int q = Integer.parseInt(scanner.nextLine().trim());
            while (q-- > 0) {
                String[] line = scanner.nextLine().trim().split(" ");
                int n = Integer.parseInt(line[0]);
                int leap = Integer.parseInt(line[1]);

                String[] gameStr = scanner.nextLine().trim().split(" ");
                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = Integer.parseInt(gameStr[i]);
                }

                System.out.println(canWin(leap, game));
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }

    public static boolean canWin(int leap, int[] game, int position) {
        int n = game.length;
        if (position < 0 || game[position] != 0) {
            return false;
        }
        if (position >= n - 1 || position + leap >= n) {
            return true;
        }
        game[position] = 1;
        return canWin(leap, game, position + 1) ||
                canWin(leap, game, position - 1) ||
                canWin(leap, game, position + leap);
    }
}
