import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> personsList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];
            Employee employee = null;
            if (inputData.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (inputData.length == 5 && inputData[4].contains("@")) {
                String email = inputData[4];
                int age = -1;
                employee = new Employee(name, salary, position, department, email);
            } else if (inputData.length == 5 && !inputData[4].contains("@")) {
                int age = Integer.parseInt(inputData[4]);
                employee = new Employee(name, salary, position, department, age);
            } else if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            personsList.putIfAbsent(department, new Department(department));
            personsList.get(department).getEmployees().add(employee);

        }
        Department highestDepartment = personsList.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().averageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getName());
        highestDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(System.out::println);
    }
}
