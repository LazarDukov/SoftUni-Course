import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class june13OsPlanning {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();//stack
        ArrayDeque<Integer> threads = new ArrayDeque<>();//queue
        int[] taskInput = Arrays.stream(cs.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threadInput = Arrays.stream(cs.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer t : taskInput) {
            tasks.push(t);
        }
        for (Integer t : threadInput) {
            threads.add(t);
        }
        int taskValue = Integer.parseInt(cs.nextLine());
        boolean isKilled = false;
        while (!isKilled) {
            if (tasks.peek() == taskValue) {
                isKilled = true;
                break;
            }
            if (tasks.peek() <= threads.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }

        }
        System.out.println("Thread with value " + threads.peek() + " killed task " + taskValue);
        for (Integer t : threads) {
            System.out.print(t + " ");
        }
    }
}
