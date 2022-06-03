import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class e9t5WriteEveryThirdLine {
    public static void main(String[] args) {
        try (FileInputStream inputFile = new FileInputStream("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\input.txt");
             FileOutputStream outputFile = new FileOutputStream("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\e9t5WriteEveryThirdLine.txt")) {
            int oneByte = inputFile.read();
            int counter = 1;
            while (oneByte >= 0) {
                char symbol = (char)oneByte;
                if (symbol==10) {
                    counter++;
                }
                if (counter%3 == 0) {
                    outputFile.write(symbol);
                }
                oneByte = inputFile.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
