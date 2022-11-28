import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FindAllAddresses {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Address> resultList = entityManager.createQuery("SELECT a FROM Address a " +
                " ORDER BY a.employees.size DESC", Address.class).setMaxResults(10).getResultList();
        for (Address result : resultList) {
            System.out.printf("%s, %s - %d employees%n",
                    result.getText(),
                    result.getTown().getName(),
                    result.getEmployees().size());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
