import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class dec15MeetingProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();//stack
        ArrayDeque<Integer> females = new ArrayDeque<>();//queue
        int[] malesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] femalesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(malesInput).forEach(males::push);
        Arrays.stream(femalesInput).forEach(females::add);
        int matches = 0;
        while (!(males.isEmpty() || females.isEmpty())) {
            if (males.peek() <= 0) {
                males.pop();
                continue;
            }
            if (females.peek() <= 0) {
                females.poll();
                continue;
            }
            if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            if (males.peek().equals(females.peek())) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                int value = males.pop();
                males.push(value - 2);
            }
        }
        List<String> malesList = new ArrayList<>();
        while (!males.isEmpty()) {
            malesList.add(males.pop().toString());
        }
        List<String> femalesList = new ArrayList<>();
        while (!females.isEmpty()) {
            femalesList.add(females.pop().toString());
        }
        System.out.println("Matches: " + matches);
        if (malesList.size() > 0) {
            System.out.print("Males left: ");
            String result = String.join(", ", malesList);
            System.out.println(result);
        } else {
            System.out.println("Males left: none");
        }
        if (femalesList.size() > 0) {
            System.out.print("Females left: ");
            String result = String.join(", ", femalesList);
            System.out.println(result);
        } else {
            System.out.println("Females left: none");
        }
    }

    public static boolean isEmpty(ArrayDeque<Integer> males, ArrayDeque<Integer> females) {
        boolean isEmpty = false;
        if (males.isEmpty()) {
            isEmpty = true;
        } else if (females.isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;
    }

}
