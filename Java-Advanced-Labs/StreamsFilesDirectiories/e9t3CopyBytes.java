import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class e9t3CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\input.txt";
        FileInputStream file;
        FileOutputStream output;

        try {
            file = new FileInputStream(path);
            output = new FileOutputStream("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\e9t3output.txt");

            int oneByte = file.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    output.write(oneByte);
                } else {
                    String symbols = String.valueOf(oneByte);
                    for (int i = 0; i < symbols.length(); i++) {
                        output.write(symbols.charAt(i));
                    }
                }
                oneByte = file.read();
            }


        } catch (IOException e) {

        }


    }
}
