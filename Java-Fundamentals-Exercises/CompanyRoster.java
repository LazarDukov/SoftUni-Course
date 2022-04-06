import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    static class Peoples {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        Peoples(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;


        }

        double getSalary() {
            return this.salary;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        String getDepartment() {
            return this.department;
        }
    }
        static class Department {
            String name;
            double salary;
            int count;

            Department(String name, double salary, int count) {
                this.name = name;
                this.salary = salary;
                this.count = count;
            }

            String getName() {
                return this.name;
            }


            double getSalary() {
                return this.salary;
            }

            int getCount() {
                return this.count;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // name, salary, position, department, email, and age.
            int n = Integer.parseInt(sc.nextLine());
            List<Peoples> myListOfPeoples = new ArrayList<>();
            List<Department> myListOfDepartment = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String inputData = sc.nextLine();
                List<String> newDataPeoples = Arrays.stream(inputData.split("\\s+")).collect(Collectors.toList());
                String name = newDataPeoples.get(0);
                double salary = Double.parseDouble(newDataPeoples.get(1));
                String position = newDataPeoples.get(2);
                String department = newDataPeoples.get(3);
                String email = "n/a";
                int age = -1;


                if (newDataPeoples.size() == 6) {
                    email = newDataPeoples.get(4);
                    age = Integer.parseInt(newDataPeoples.get(5));
                    Peoples people = new Peoples(name, salary, position, department, email, age);
                    myListOfPeoples.add(people);
                } else if (newDataPeoples.size() == 5 && newDataPeoples.get(4).contains("@")) {
                    email = newDataPeoples.get(4);
                    Peoples people = new Peoples(name, salary, position, department, email, age);
                    myListOfPeoples.add(people);
                } else if (newDataPeoples.size() == 5 && (!newDataPeoples.get(4).contains("@"))) {
                    age = Integer.parseInt(newDataPeoples.get(4));
                    Peoples people = new Peoples(name, salary, position, department, email, age);
                    myListOfPeoples.add(people);
                } else if (newDataPeoples.size() == 4) {
                    Peoples people = new Peoples(name, salary, position, department, email, age);
                    myListOfPeoples.add(people);
                }
                Department singleDepartment = myListOfDepartment.stream().filter(d -> d.getName().equals(department)).findFirst().orElse(null);
                if (singleDepartment == null) {
                    Department departmentToAdd = new Department(department, salary, 1);
                    myListOfDepartment.add(departmentToAdd);
                } else {
                    singleDepartment.setSalary(singleDepartment.getSalary() + salary);
                    singleDepartment.setCount(singleDepartment.getCount() + 1);
                }

            }
            double highestSalaryOfDepartment = 0.00;
            String departToPrint = " ";
            for (Department dep : myListOfDepartment) {
                double averageSalary = dep.salary / dep.count;
                if (averageSalary > highestSalaryOfDepartment) {
                    highestSalaryOfDepartment = averageSalary;
                    departToPrint = dep.name;
                }
            }
            System.out.printf("Highest Average Salary: %s%n", departToPrint);
            String finalToPrint = departToPrint;
            myListOfPeoples.stream().filter(s -> s.getDepartment().equals(finalToPrint)).sorted(Comparator.comparing(Peoples::getSalary).reversed())
                    .collect(Collectors.toList())
                    .forEach(s -> System.out.printf("%s %.2f %s %d%n", s.getName(), s.getSalary(), s.getEmail(), s.getAge()));
        }
}
