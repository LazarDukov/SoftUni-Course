package SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(reader.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            people.add(new Person(firstName, lastName, age));
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int compareNames = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (compareNames != 0) {
                return compareNames;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }


}
