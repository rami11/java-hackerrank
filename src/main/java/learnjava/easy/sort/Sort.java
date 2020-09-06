package learnjava.easy.sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input2.txt"));
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        /*studentList.sort((std1, std2) -> {
            int i = Double.valueOf(std2.getCgpa()).compareTo(std1.getCgpa());
            if (i != 0) {
                return i;
            }
            int j = std1.getFname().compareTo(std2.getFname());
            if (j != 0) {
                return j;
            }
            return std1.getId() - std2.getId();
        });*/
        /*studentList.sort(
                Comparator.comparing(Student::getCgpa)
                        .reversed()
                        .thenComparing(Student::getFname)
                        .thenComparing(Student::getId)
        );*/
        studentList.sort(new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
