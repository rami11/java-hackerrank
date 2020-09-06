package learnjava.easy.sort;

import java.util.Comparator;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student std1, Student std2) {
        return Comparator.comparing(Student::getCgpa)
                .reversed()
                .thenComparing(Student::getFname)
                .thenComparing(Student::getId)
                .compare(std1, std2);
    }
}
