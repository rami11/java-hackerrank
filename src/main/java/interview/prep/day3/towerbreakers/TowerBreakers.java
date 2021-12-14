package interview.prep.day3.towerbreakers;

public class TowerBreakers {

    public static void main(String[] args) {
        int result = towerBreakers(3, 1); // 2
        System.out.println(result);

        result = towerBreakers(2, 10); // 2
        System.out.println(result);

        result = towerBreakers(3, 10); // 1
        System.out.println(result);
    }

    public static int towerBreakers(int n, int m) {
        if (n % 2 == 0 || m == 1) {
            return 2;
        }
        return 1;
    }
}