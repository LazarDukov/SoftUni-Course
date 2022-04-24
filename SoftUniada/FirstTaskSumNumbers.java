import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTaskSumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int nod = 1;
        for (int i = 1; i <= Math.min(firstNum, secondNum); i++) {
            if (firstNum % i == 0 && secondNum % i == 0 && nod < i) {
                nod = i;
            }
        }
        int nok = 1;
        int fN = firstNum;
        int sN = secondNum;
        while (true) {

            if (fN > sN) {
                sN += secondNum;
            } else if (sN > fN) {
                fN += firstNum;
            } else {
                nok = fN;
                break;
            }
        }

        int sum = nod + nok;
        System.out.println(sum);
    }
}
