import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class e9t2WriteToFile {
    public static void main(String[] args) {
        String path = "D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\input.txt";
        FileInputStream inputFile;
        FileOutputStream outputFile;
        List<Character> symbols = new ArrayList<>();
        symbols.add(',');
        symbols.add('.');
        symbols.add('!');
        symbols.add('?');

        try {
            inputFile = new FileInputStream(path);
            outputFile = new FileOutputStream("D:\\Others documents\\SoftUni\\SoftuniAdvanced\\src\\e9t2output.txt");
            int oneByte = inputFile.read();

            while (oneByte >= 0){
                if (!symbols.contains((char)oneByte)) {
                    outputFile.write(oneByte);
                }

                oneByte = inputFile.read();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
