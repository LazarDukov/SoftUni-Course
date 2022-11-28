import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SalaryOver50000 {
    private static final String GET_FIRSTNAME_OF_PEOPLE_WITH_SALARY_OVER_50000 = "SELECT e.firstName FROM Employee AS e" +
            " WHERE e.salary > 50000";

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List peoples = entityManager.createQuery(GET_FIRSTNAME_OF_PEOPLE_WITH_SALARY_OVER_50000).getResultList();
        for (int i = 0; i < peoples.size(); i++) {
            System.out.println(peoples.get(i));
        }


        entityManager.close();


    }

}
