import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGoNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (distances.size() != 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int element = 0;

            if (index < 0) {
                index = 0;
                sum += distances.get(index);
                element = distances.get(index);
                int newIndexZero = distances.get(distances.size() - 1);
                distances.set(0, newIndexZero);


            } else if (index > distances.size() -1) {
                index = distances.size()-1;
                sum += distances.get(index);
                element = distances.get(index);
                int newLastIndex = distances.get(0);
                distances.set(distances.size()-1, newLastIndex);


            } else {
                element = distances.get(index);
                sum += distances.get(index);
                distances.remove(index);
            }

            for (int i = 0; i < distances.size(); i++) {
                int newValue = 0;
                if (distances.get(i) <= element) {
                    newValue = element + distances.get(i);
                    distances.set(i, newValue);
                } else if (distances.get(i) > element) {
                    newValue = distances.get(i) - element;
                    distances.set(i, newValue);
                }
            }
        }
        System.out.println(sum);
    }
}
