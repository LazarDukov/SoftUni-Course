import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> query = entityManager.createQuery("SELECT e FROM Employee AS e" +
                " WHERE e.department.name = 'Research and Development'" +
                " ORDER BY e.salary, e.id", Employee.class).getResultList();
        for (Employee q : query) {
            System.out.printf("%s %s from %s - $%.2f%n", q.getFirstName(), q.getLastName(), q.getDepartment().getName(), q.getSalary());
        }


        entityManager.close();

    }
}
