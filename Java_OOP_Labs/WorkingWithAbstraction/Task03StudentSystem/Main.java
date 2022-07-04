package StudentSystemPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];
        while (!command.equals("Exit")) {
            String studentName = input[1];

            if (command.equals("Create")) {
                studentSystem.create(input);

            } else if (command.equals("Show")) {
                Student student = studentSystem.getStudents().get(studentName);
                if (student != null) {
                    System.out.println(student.toString() + student.getCommentary());
                }
            }

            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }

}
