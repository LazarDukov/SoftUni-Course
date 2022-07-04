package StudentSystemPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void create(String input[]) {
        String studentName = input[1];
        int studentAge = Integer.parseInt(input[2]);
        double studentGrade = Double.parseDouble(input[3]);

        students.putIfAbsent(studentName, new Student(studentName, studentAge, studentGrade));
        students.get(studentName).setCommentary();
    }

}
