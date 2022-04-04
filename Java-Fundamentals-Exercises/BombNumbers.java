import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        String[] bombNumbers = input.split("\\s+");
        int bomb = Integer.parseInt(bombNumbers[0]);
        int power = Integer.parseInt(bombNumbers[1]);
        int indexOfBomb = 0;
        while (numbers.contains(bomb)) {

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(Integer.valueOf(i)).equals(bomb)) {
                    indexOfBomb = i;
                }
            }
            if (power==0) {
                numbers.remove(indexOfBomb);
                continue;
            }
            int lengthOfList = numbers.size();
            int newIndexOfBomb = 0;
            for (int i = 1; i <= power; i++) {
                if (indexOfBomb - i <= 0) {
                    break;
                } else {
                    numbers.remove(indexOfBomb - i);
                }
                newIndexOfBomb = numbers.size();
            }
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(Integer.valueOf(i)).equals(bomb)) {
                    newIndexOfBomb = i;
                }
            }

            for (int i = 1; i <= power; i++) {
                if (newIndexOfBomb + i > numbers.size()-1) {
                    break;
                } else {
                    numbers.remove(newIndexOfBomb + i);
                }
            }
            numbers.remove(newIndexOfBomb);
        }
        long sum = 0;
        for (int n: numbers) {
            sum+=n;
        }
        System.out.println(sum);
    }
}
