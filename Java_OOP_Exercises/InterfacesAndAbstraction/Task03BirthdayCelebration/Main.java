package InterfacesAndAbstraciton.ExTask03;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Birthable> items = new ArrayList<>();
        while (!"End".equals(input[0])) {

            switch (input[0]) {
                case "Citizen":
                    //"Citizen {name} {age} {id} {birthdate}"
                    String nameOfCitizen = input[1];
                    int ageOfCitizen = Integer.parseInt(input[2]);
                    String idOfCitizen = input[3];
                    String birthDateOfCitizen = input[4];
                    Birthable citizen = new Citizen(nameOfCitizen, ageOfCitizen, idOfCitizen, birthDateOfCitizen);
                    items.add(citizen);
                    break;

                case "Pet":
                    //"Pet {name} {birthdate}"
                    String nameOfPet = input[1];
                    String birthDateOfPet = input[2];
                    Birthable pet = new Pet(nameOfPet, birthDateOfPet);
                    items.add(pet);
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
        String yearToCheck = scanner.nextLine();

        items.stream().filter(i -> i.getBirthDate().endsWith(yearToCheck)).forEach(i -> System.out.println(i.getBirthDate()));
    }


}
