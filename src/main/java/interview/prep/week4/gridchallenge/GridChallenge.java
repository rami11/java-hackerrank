package interview.prep.week4.gridchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridChallenge {

    public static void main(String[] args) {

        System.out.println(gridChallenge(List.of("abc", "ade", "efg")));
        System.out.println(gridChallenge(List.of("hcd", "awc", "shm")));
    }

    public static String gridChallenge(List<String> grid) {

        List<List<Character>> sortedGrid = getSortedGrid(grid);

        return isColumnsSorted(sortedGrid) ? "YES" : "NO";
    }

    private static boolean isColumnsSorted(List<List<Character>> sortedGrid) {

        int rows = sortedGrid.size();
        int cols = sortedGrid.get(0).size();

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                char c1 = sortedGrid.get(row).get(col);
                char c2 = sortedGrid.get(row + 1).get(col);
                if (c1 > c2) {
                    return false;
                }
            }
        }

        return true;
    }

    private static List<List<Character>> getSortedGrid(List<String> grid) {
        List<List<Character>> sortedGrid = new ArrayList<>();

        for (String str : grid) {

            List<Character> rowChars = str.chars()
                    .sorted()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());

            sortedGrid.add(rowChars);
        }

        return sortedGrid;
    }
}
