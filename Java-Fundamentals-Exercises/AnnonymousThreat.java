import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnnonymousThreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        String in = sc.nextLine();
        while (!in.equals("3:1")) {
            List<String> inputList = Arrays.asList(in.split("\\s+"));
            String firstElement = inputList.get(0);

            switch (firstElement) {
                case "merge":
                    int start = Integer.parseInt(inputList.get(1));
                    int end = Integer.parseInt(inputList.get(2));
                    int minus = 0;
                    if (list.size() == 1) {
                        break;
                    }
                    if (start < list.size()) {
                        for (int i = start; i < end; i++) {
                            if (i > list.size()) {
                                break;
                            }
                            String first = list.get(start);
                            String second = list.get(start + 1);
                            String newA = first.concat(second);
                            list.set(start, newA);
                            list.remove(start + 1);
                            minus++;
                        }

                    } else {
                        for (int i = 0; i < list.size() - 1; i++) {
                            String first = list.get(0);
                            String second = list.get(1);
                            String newA = first.concat(second);
                            list.set(0, newA);
                            list.remove(1);
                        }
                    }
                    break;
                case "divide":
                    // lazardukov
                    String strToDiv = list.get(Integer.parseInt(inputList.get(1))); // lazardukov
                    int parts = Integer.parseInt(inputList.get(2)); //
                    //
                    if (parts % 2 == 0) {
                        int partsNeeded = strToDiv.length() / parts;
                        String[] arr = new String[parts];
                        String newA;
                        int j = 0;
                        int u = 0;
                        for (int i = 0; i < parts; i++) {
                            newA = "";
                            for (j = j; j < u + partsNeeded; j++) {
                                char a = strToDiv.charAt(j);
                                newA += a;
                            }
                            arr[i] = newA;
                            u = j;
                        }
                        for (int i = arr.length - 1; i >= 0; i--) {
                            list.add(Integer.parseInt(inputList.get(1)), arr[i]);
                        }
                        int index = arr.length;
                        list.remove(Integer.parseInt(inputList.get(1)) + index);
                    } else {
                        String[] arr = new String[parts];            // lazarRUMENOVdukov123
                        int partsNeeded = strToDiv.length() / parts;   // 20/3 = 6
                        String newA;
                        int j = 0;
                        int u = 0;
                        for (int i = 0; i < parts - 1; i++) {
                            newA = "";
                            for (j = j; j < u + partsNeeded; j++) {
                                char a = strToDiv.charAt(j);
                                newA += a;
                            }
                            arr[i] = newA;
                            u = j;
                        }
                        String newB = "";
                        for (int i = j; i < strToDiv.length(); i++) {
                            char a = strToDiv.charAt(j);
                            newB += a;

                            j++;
                        }
                        arr[arr.length - 1] = newB;

                        for (int i = arr.length - 1; i >= 0; i--) {
                            list.add(Integer.parseInt(inputList.get(1)), arr[i]);
                        }
                        int index = arr.length;
                        list.remove(Integer.parseInt(inputList.get(1)) + index);
                    }

                    break;
            }


            in = sc.nextLine();
        }
        for (String m : list
        ) {
            System.out.print(m + " ");
        }

    }
}