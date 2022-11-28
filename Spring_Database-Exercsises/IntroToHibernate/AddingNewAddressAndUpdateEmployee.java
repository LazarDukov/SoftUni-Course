import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingNewAddressAndUpdateEmployee {
    //private static final String ADDING_NEW_ADDRESS = "INSERT ";
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        entityManager.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);
        String lastNameGiven = scanner.nextLine();
        entityManager.persist(newAddress);
        int counter = entityManager.createQuery("UPDATE Employee AS e " +
                " SET e.address = :newAddress WHERE e.lastName = :lastName")
                .setParameter("newAddress", newAddress)
                .setParameter("lastName", lastNameGiven)
                .executeUpdate();
        if (counter <= 0) {
            entityManager.getTransaction().rollback();
        } else {
            entityManager.getTransaction().commit();
        }
        entityManager.close();


        System.out.println(counter);


    }
}
