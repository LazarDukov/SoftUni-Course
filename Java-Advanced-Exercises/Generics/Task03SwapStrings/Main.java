package generics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box list = new Box();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            list.add(input);
        }
        String[] indeces = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(indeces[0]);
        int secondIndex = Integer.parseInt(indeces[1]);
        list.swap(firstIndex, secondIndex);
        System.out.println(list.toString());
    }
}
