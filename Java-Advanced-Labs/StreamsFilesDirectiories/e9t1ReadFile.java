import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class e9t1ReadFile {
    public static void main(String[] args) {
        String input = "D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\input.txt";
        FileInputStream file;
        try {
            file = new FileInputStream(input);

            int oneByte = file.read();
            while (oneByte != -1) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
