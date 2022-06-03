import java.util.ArrayDeque;
import java.util.Scanner;

public class e4t3MaximalElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int findMax = 0;
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            if (commands[0].equals("1")) {
                stack.push(Integer.parseInt(commands[1]));
            } else if (commands[0].equals("2")) {
                stack.pop();
            } else if (commands[0].equals("3")) {
                while (!stack.isEmpty()) {
                    if (stack.peek() > findMax) {
                        findMax = stack.peek();

                    }
                    stack.pop();
                }
                System.out.println(findMax);
            }
            findMax = 0;
        }
    }
}
