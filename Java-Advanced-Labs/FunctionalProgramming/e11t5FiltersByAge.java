import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class e11t5FiltersByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person p = new Person(name, age);
            persons.add(p);
        }
        String conditionFilter = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String formatFilter = scanner.nextLine();
        System.out.println();
        persons = filterByAgeCondition(persons, getPredicate(conditionFilter, ageFilter));
        Consumer<Person> toPrint = getPrint(formatFilter);


        persons.forEach(toPrint);

    }

    public static Consumer<Person> getPrint(String formatFilter) {
        if (formatFilter.equals("name")) {
            return p -> System.out.println(p.name);
        } else if (formatFilter.equals("age")) {
            return p -> System.out.println(p.age);
        } else if (formatFilter.equals("name age")) {
            return p -> System.out.println(p.name + " - " + p.age);
        } else throw new IllegalArgumentException("Unknown format");
    }

    public static Predicate<Person> getPredicate(String condition, int age) {
        if (condition.equals("younger")) {
            return p -> p.age <= age;
        } else if (condition.equals("older")) {
            return p -> p.age >= age;
        } else {
            throw new IllegalArgumentException("Unknown parameters");
        }
    }

    public static List<Person> filterByAgeCondition(List<Person> persons, Predicate<Person> getPredicate) {
        return persons.stream().filter(getPredicate).collect(Collectors.toList());

    }
}
