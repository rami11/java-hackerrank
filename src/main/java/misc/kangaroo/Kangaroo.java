package misc.kangaroo;

public class Kangaroo {

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));

        System.out.println(kangaroo(0, 2, 5, 3));

        System.out.println(kangaroo(21, 6, 47, 3)); // NO

        System.out.println(kangaroo(14, 4, 98, 2));

        System.out.println(kangaroo(4523,8092, 9419, 8076));
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        while (x1 < x2) {
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                return "YES";
            }
        }
        return "NO";
    }
}
