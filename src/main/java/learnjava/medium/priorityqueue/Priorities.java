package learnjava.medium.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(
                Comparator.comparingDouble(Student::getCgpa)
                .reversed()
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getId));

        for (String event : events) {
            String[] splitEvent = event.split(" ");
            String action = splitEvent[0];
            if (action.equals("ENTER")) {
                String name = splitEvent[1];
                double cgpa = Double.parseDouble(splitEvent[2]);
                int id = Integer.parseInt(splitEvent[3]);
                queue.offer(new Student(id, name, cgpa));
            } else if (action.equals("SERVED")) {
                queue.poll();
            }
        }
        List<Student> studentList = new ArrayList<>();
        while (!queue.isEmpty()) {
            studentList.add(queue.poll());
        }
        return studentList;
    }
}
