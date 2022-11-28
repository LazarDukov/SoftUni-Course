import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeCasing {
        private static final String GETTING_ALL_NAMES_WITH_LENGHT_MORE_THAN_5 =
                "UPDATE Town AS t SET t.name = upper(t.name) WHERE LENGTH(t.name) > 5";
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery(GETTING_ALL_NAMES_WITH_LENGHT_MORE_THAN_5).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
