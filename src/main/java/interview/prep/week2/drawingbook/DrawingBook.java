package interview.prep.week2.drawingbook;

public class DrawingBook {

    public static void main(String[] args) {
        System.out.println(pageCount(6, 2));
    }

    public static int pageCount(int n, int p) {
        int pairs = n / 2 + 1; // number of pairs
        int pageAtPair = p / 2 + 1; // pair num at which the page is
        return Math.min(pageAtPair - 1, pairs - pageAtPair);
    }

}
