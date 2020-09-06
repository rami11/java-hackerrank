package learnjava.medium.priorityqueue;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student std1, Student std2) {
        return Comparator.comparingDouble(Student::getCgpa)
                .reversed()
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getId)
                .compare(std1, std2);
    }
}
