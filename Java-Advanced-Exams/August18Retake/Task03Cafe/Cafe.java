package cafe;

import java.util.*;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    // Method addEmployee(Employee employee) – adds an entity to the data if there is room for him/her.
    public void addEmployee(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    //•	Method removeEmployee(String name) – removes an employee by given name, if such exists, and returns a bool.
    public boolean removeEmployee(String name) {
        Employee employee;
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                this.employees.remove(e);
                return true;
            }
        }
        return false;

    }

    //•	Method getOldestEmployee() – returns the oldest employee.
    public Employee getOldestEmployee() {
        int oldest = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee e : this.employees) {
            if (e.getAge() > oldest) {
                oldest = e.getAge();
                employee = e;
            }
        }

        return employee;
    }

    //•	Method getEmployee(string name) – returns the employee with the given name.
    public Employee getEmployee(String name) {
        Employee employee = null;
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                employee = e;
            }
        }
        return employee;
    }

    //•	Getter getCount() – returns the number of employees.
    public int getCount() {
        return employees.size();
    }

    //•	report() – returns a string in the following format:
    //o	"Employees working at Cafe {cafeName}:
    //  {Employee1}
    //  {Employee2}
    //  (…)"
    public String report() {
        return ("Employees working at Cafe " + this.name + ": " + System.lineSeparator() +
                this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator())));

    }
}
