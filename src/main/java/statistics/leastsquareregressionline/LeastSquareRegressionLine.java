package statistics.leastsquareregressionline;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// Expected result 78.288
public class LeastSquareRegressionLine {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("lsrl.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            Map<Integer, Integer> mapXtoY = new HashMap<>();
            String line;
            int x, y;
            String[] lineArray;
            while ((line = reader.readLine()) != null) {
                lineArray = line.split(" ");
                x = Integer.parseInt(lineArray[0]);
                y = Integer.parseInt(lineArray[1]);
                mapXtoY.put(x, y);
            }

            double result = solution(mapXtoY);
            writer.write(String.format("%.3f", result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double solution(Map<Integer, Integer> mapXtoY) {
        int n = mapXtoY.size();
        int sumX = 0, sumY = 0, sumSquareX = 0, sumXY = 0;
        for (Map.Entry<Integer, Integer> entry : mapXtoY.entrySet()) {
            sumX += entry.getKey();
            sumY += entry.getValue();
            sumSquareX += Math.pow(entry.getKey(), 2);
            sumXY += entry.getKey() * entry.getValue();
        }
        double meanX = sumX / n;
        double meanY = sumY / n;

        double b = (n * sumXY - sumX * sumY) / (n * sumSquareX - Math.pow(sumX, 2));
        double a = meanY - b * meanX;

        //for x = 80
        double result = a + b * 80;

        return Math.round(result * 1000d) / 1000d;
    }

}
