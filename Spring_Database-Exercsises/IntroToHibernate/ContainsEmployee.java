import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class ContainsEmployee {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Scanner scanner = new Scanner(System.in);

        String[] name = scanner.nextLine().split(" ");
            String firstName = name[0];
            String lastName = name[1];
        entityManager.getTransaction().begin();

        Long countOfMatches = entityManager.createQuery("SELECT COUNT(e) FROM Employee AS e WHERE e.firstName = :fn AND e.lastName = :ln", Long.class)
                .setParameter("fn", firstName).setParameter("ln", lastName).getSingleResult();

        if (countOfMatches == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        entityManager.close();
    }
}
