import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory etm = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager et = etm.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        et.getTransaction().begin();
        List<Employee> peoples = et.createQuery("SELECT e FROM Employee e " +
                " WHERE e.id = :id", Employee.class).setParameter("id", id).getResultList();

        for (Employee people : peoples) {
            System.out.printf("%s, %s - %s%n%s", people.getFirstName(), people.getLastName(), people.getJobTitle(),
                    people.getProjects().stream().map(Project::getName).sorted().collect(Collectors.joining(System.lineSeparator())));
        }
        et.close();
    }
}
