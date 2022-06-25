package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    //Next, write a Java class Workout that has exercises (List, which stores the entity Exercise).
    // All entities inside the repository have the same fields. Also, the Workout class should have those fields:
    //•	type: String
    //•	exerciseCount: int
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises = new ArrayList<>();

    //The class constructor should receive type and exerciseCount,
    // also it should initialize the exercises with a new instance of the list.
    // Implement the following features:

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    //•	Method addExercise(Exercise exercise) – adds an entity to the exercises
    // If there is still space on the workout sheet (exerciseCount).
    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    //•	Method removeExercise(String name, String muscle) –
    // removes the exercise by given name and muscle,
    // if such exists, and returns boolean.
    public boolean removeExercise(String name, String muscle) {
        for (var e : this.exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                return this.exercises.remove(e);
            }
        }
        return false;
    }

    //•	Method getExercise(String name, String muscle) –
    // returns the exercise with the given name and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle) {
        Exercise exercise = null;
        for (var e : this.exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                exercise = e;
            }
        }
        return exercise;
    }

    //•	Method getMostBurnedCaloriesExercise() –
    // returns the exercise which is burned the most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    //•	Getter getExerciseCount() – returns the number of exercises.
    public int getExerciseCount() {
        return this.exercises.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"

    public String getStatistics() {
        String toPrint = String.format("Workout type: %s" + System.lineSeparator(), this.type);
        return toPrint + this.exercises.stream().map(Exercise::toString).collect(Collectors.joining(System.lineSeparator()));
    }

}
