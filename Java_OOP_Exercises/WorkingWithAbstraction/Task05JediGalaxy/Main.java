package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = setMatrixDimensions(dimensions);

        String command = scanner.nextLine();
        long sum = 0;
        while (!"Let the Force be with you".equals(command)) {
            int[] jediSteps = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilSteps = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            setStarNullPoints(matrix, evilSteps);

            sum = jediSumStars(matrix, sum, jediSteps);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long jediSumStars(int[][] matrix, long sum, int[] jediSteps) {
        int jediFirstRowStep = jediSteps[0];
        int jediFirstColStep = jediSteps[1];

        while (jediFirstRowStep >= 0 && jediFirstColStep < matrix[1].length) {
            if (isInRange(matrix, jediFirstRowStep, jediFirstColStep)) {
                sum += matrix[jediFirstRowStep][jediFirstColStep];
            }

            jediFirstColStep++;
            jediFirstRowStep--;
        }
        return sum;
    }

    private static void setStarNullPoints(int[][] matrix, int[] evilSteps) {
        int evilFirstRowStep = evilSteps[0];
        int evilFirstColStep = evilSteps[1];

        while (evilFirstRowStep >= 0 && evilFirstColStep >= 0) {
            if (isInRange(matrix, evilFirstRowStep, evilFirstColStep)) {
                matrix[evilFirstRowStep][evilFirstColStep] = 0;
            }
            evilFirstRowStep--;
            evilFirstColStep--;
        }
    }

    private static boolean isInRange(int[][] matrix, int evilFirstRowStep, int evilFirstColStep) {
        return evilFirstRowStep >= 0 && evilFirstRowStep < matrix.length && evilFirstColStep >= 0 && evilFirstColStep < matrix[0].length;
    }

    private static int[][] setMatrixDimensions(int[] dimensions) {
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
