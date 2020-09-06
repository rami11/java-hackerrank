package misc.gridchallenge;

import java.util.Arrays;

public class GridChallenge {

    public static void main(String[] args) {
        String[] rows = {"ebacd", "fghij", "olmkn", "trpqs", "xywuv"};

        System.out.println(gridChallenge(rows));

        String[] rows1 = {"abc", "lmp", "qrt"};
        System.out.println(gridChallenge(rows1));

        String[] rows2 = {"mpxz", "abcd", "wlmf"};
        System.out.println(gridChallenge(rows2));

        String[] rows3 = {"abc", "hjk", "mpq", "rtv"};
        System.out.println(gridChallenge(rows3));

        String[] aa = {};
        System.out.println(gridChallenge(aa));
    }

    private static String gridChallenge(String[] grid) {
        try {
            // sort string elements
            for (int i = 0; i < grid.length; i++) {
                String[] row = grid[i].split("");
                Arrays.sort(row);
                grid[i] = String.join("", row);
            }

            for (int i = 0; i < grid[0].length(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : grid) {
                    stringBuilder.append(s.charAt(i));
                }
                String columnString = stringBuilder.toString();

                String[] columnArray = stringBuilder.toString().split("");
                Arrays.sort(columnArray);
                String sortedColumnString = String.join("", columnArray);

                if (!columnString.equals(sortedColumnString)) {
                    return "NO";
                }
            }
            return "YES";
        } catch (Exception e) {
            return "Error!";
        }
    }

}
