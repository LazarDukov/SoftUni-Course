import java.io.*;
import java.util.Scanner;

public class e9t4ExtractedIntegers {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\input.txt"));
            PrintWriter toPrint = new PrintWriter(new File("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\e9t4ExtractedIntegers.txt"))){
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    toPrint.println(scan.nextInt());

                }
                scan.next();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

