import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        String commandsLine = scanner.nextLine();
        while (!commandsLine.equals("Finish")) {
            String[] commands = commandsLine.split("\\s+");
            String toDo = commands[0];
            switch (toDo) {
                case "Replace":
                    String currentChar = commands[1];
                    String newChar = commands[2];
                    String newText = text.toString().replace(currentChar, newChar);
                    StringBuilder formattedText = new StringBuilder(newText);
                    text = formattedText;
                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndexCut = Integer.parseInt(commands[1]);
                    int endIndexCut = Integer.parseInt(commands[2]);
                    if (startIndexCut > -1  && endIndexCut <= text.length()) {


                        //  String substringText = text.substring(startIndex, endIndexCut +1);
                        text.delete(startIndexCut, endIndexCut + 1);
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    if (commands[1].equals("Upper")) {
                        String text1 = text.toString().toUpperCase();
                        StringBuilder textFirst = new StringBuilder(text1);
                        text = textFirst;
                        System.out.println(text);
                    } else if (commands[1].equals("Lower")) {
                        String text2 = text.toString().toLowerCase();
                        StringBuilder textSecond = new StringBuilder(text2);
                        text = textSecond;
                        System.out.println(text);
                    }
                    break;
                case "Check":
                    if (text.toString().contains(commands[1])) {
                        System.out.println("Message contains " + commands[1]);
                    } else {
                        System.out.println("Message doesn't contain " + commands[1]);
                    }
                    break;
                case "Sum":
                    int startIndexSum = Integer.parseInt(commands[1]);
                    int endIndexSum = Integer.parseInt(commands[2]);
                    if (startIndexSum > -1 && startIndexSum < text.length()-1 && endIndexSum >0 && endIndexSum < text.length()) {
                        String toSum = text.substring(Integer.parseInt(commands[1]), Integer.parseInt(commands[2])+1);
                        int sum = 0;
                        for (int i = 0; i < toSum.length(); i++) {
                            char symbol = toSum.charAt(i);
                            sum += symbol;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
            }

            commandsLine = scanner.nextLine();
        }
    }
}
