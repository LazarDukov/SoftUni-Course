package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> person = new LinkedHashMap<>();
        String[] inputPersons = scanner.nextLine().split(";");

        for (int i = 0; i < inputPersons.length; i++) {
            String[] personData = inputPersons[i].split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);
            try {
                Person newPerson = new Person(personName, personMoney);
                person.putIfAbsent(personName, newPerson);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Map<String, Product> product = new HashMap<>();
        String[] inputProducts = scanner.nextLine().split(";");

        for (int i = 0; i < inputProducts.length; i++) {
            String[] productData = inputProducts[i].split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);
            try {
                product.putIfAbsent(productName, new Product(productName, productCost));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }
        String[] buying = scanner.nextLine().split("\\s+");
        String peopleWhoBuying = buying[0];

        while (!"END".equals(peopleWhoBuying)) {
            String productToBuy = buying[1];
            try {
                person.get(peopleWhoBuying).buyProduct(product.get(productToBuy));
                System.out.printf("%s bought %s%n", peopleWhoBuying, productToBuy);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            buying = scanner.nextLine().split("\\s+");
            peopleWhoBuying = buying[0];
        }
        for (Person p : person.values()) {
            if (p.getProducts().size() > 0) {
                System.out.println(p.toString());
            } else {
                System.out.println(p.getName() + " - Nothing bought");
            }
        }
    }
}
