package StudentSystemPackage;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String commentary = "";

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void setCommentary() {
        if (this.grade >= 5.00) {
            this.commentary = "Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            this.commentary = "Average student.";
        } else {
            this.commentary = "Very nice person.";
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCommentary() {
        return commentary;
    }

    @Override
    public String toString() {
        return String.format("%s is %d years old. ", this.getName(), this.getAge());
    }
}
