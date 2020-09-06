package misc.staircase;

public class Staircase {

    public static void main(String[] args) {

        staircase(5);
        System.out.println();
        staircase(10);
    }

    private static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((j >= (n - 1 - i)) ? " *" : "  ");
            }
            System.out.println();
        }
    }
}
