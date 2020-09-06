package misc.gradingstudents;

import java.util.Arrays;

public class GradingStudents {

    public static void main(String[] args) {
        int[] grades = {4, 73, 67, 38, 33};

        Arrays.stream(gradingStudents(grades)).forEach(grade -> {
            System.out.print(grade + " ");
        });
    }


    private static int[] gradingStudents(int[] grades) {
        return Arrays.stream(grades).map(grade -> {
            if (grade >= 38 && grade % 5 >= 3) {
                grade += 5 - (grade % 5);
            }
            return grade;
        }).toArray();
    }

}
