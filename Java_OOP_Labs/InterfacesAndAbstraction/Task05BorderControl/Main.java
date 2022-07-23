package InterfacesAndAbstraciton.Task05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputData = console.nextLine().split("\\s+");

        List<Identifiable> personOrRobot = new ArrayList<>();
        while (!"End".equals(inputData[0])) {
            switch (inputData.length) {
                case 3:
                    //citizen
                    String name = inputData[0];
                    int age = Integer.parseInt(inputData[1]);
                    String citizenId = inputData[2];
                    Identifiable citizen = new Citizen(name, age, citizenId);
                    personOrRobot.add(citizen);
                    break;
                case 2:
                    //robot
                    String model = inputData[0];
                    String robotId = inputData[1];
                    Identifiable robot = new Robot(model, robotId);
                    personOrRobot.add(robot);
                    break;


            }
            inputData = console.nextLine().split("\\s+");
        }

        String checkingIdNumber = console.nextLine();
        personOrRobot.stream().filter(i -> i.getId().endsWith(checkingIdNumber)).forEach(toPrint -> System.out.println(toPrint.getId()));
    }

}
