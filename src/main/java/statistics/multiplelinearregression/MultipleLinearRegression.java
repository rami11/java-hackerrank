package statistics.multiplelinearregression;

import java.io.*;
import java.util.Arrays;

public class MultipleLinearRegression {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("mlr.txt"))) {
            String[] mn = reader.readLine().trim().split(" ");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);

            double[][] labels = new double[n][1];
            double[][] features = new double[n][m + 1];
            String[] line;
            for (int i = 0; i < n; i++) {
                line = reader.readLine().trim().split(" ");
                labels[i][0] = Double.parseDouble(line[m]);
                features[i][0] = 1;
                for (int j = 0; j < m; j++) {
                    features[i][j + 1] = Double.parseDouble(line[j]);
                }
            }

            int q = Integer.parseInt(reader.readLine().trim());
            double[][] featureSet = new double[q][m + 1];
            for (int i = 0; i < q; i++) {
                line = reader.readLine().trim().split(" ");
                featureSet[i][0] = 1;
                for (int j = 0; j < m; j++) {
                    featureSet[i][j + 1] = Double.parseDouble(line[j]);
                }
            }

            double[][] B = multipleLinearRegression(features, labels);
            double[][] result = multiply(featureSet, B);
            display(result);

        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    private static double[][] multiply(double[][] X1, double[][] X2) {
        // Number of columns of X1 must be equal to the number of rows of X2
        if (X1[0].length != X2.length) {
            return new double[0][0];
        }
        double[][] result = new double[X1.length][X2[0].length];
        for (int i = 0; i < X1.length; i++) {
            for (int j = 0; j < X2[0].length; j++) {
                for (int k = 0; k < X1[0].length; k++) {
                    result[i][j] += X1[i][k] * X2[k][j];
                }
            }
        }
        return result;
    }

    private static double[][] transpose(double[][] X) {
        double[][] result = new double[X[0].length][X.length];
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X[0].length; j++) {
                result[j][i] = X[i][j];
            }
        }
        return result;
    }

    private static double[][] invert(double[][] a) {
        int n = a.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }
        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k] -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    /**
     * Method to carry out the partial-pivoting Gaussian elimination.
     * index[] stores pivoting order
     */
    private static void gaussian(double[][] a, int[] index) {
        int n = index.length;
        double[] c = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }

    private static void display(double[][] array) {
        Arrays.stream(array).forEach(row -> {
            Arrays.stream(row).forEach(cell -> System.out.print(cell + " "));
            System.out.println();
        });
    }

    private static double[][] multipleLinearRegression(double[][] features, double[][] labels) {
        double[][] X = features;
        double[][] Y = labels;

        double[][] TX = transpose(X);
        double[][] TXX = multiply(TX, X);
        double[][] invTXX = invert(TXX);
        double[][] invTXXTX = multiply(invTXX, TX);

        double[][] B = multiply(invTXXTX, Y);

        return B;
    }

}
