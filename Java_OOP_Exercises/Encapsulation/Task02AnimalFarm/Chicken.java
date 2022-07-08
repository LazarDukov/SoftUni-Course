package Chicken;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private void setName(String name) {
        checkIsNameValid(name);
        this.name = name;
    }

    private void setAge(int age) {
        checkIsAgeValid(age);
        this.age = age;
    }

    private void checkIsNameValid(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 2) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void checkIsAgeValid(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (age < 6) {
            return 2.00;
        } else if (age < 12) {
            return 1.00;
        } else {
            return 0.75;
        }
    }

    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(), getAge(), productPerDay());
    }
}
