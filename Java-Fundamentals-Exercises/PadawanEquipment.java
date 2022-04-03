import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double oneLightSaber = Double.parseDouble(scanner.nextLine());
        double robes = Double.parseDouble(scanner.nextLine());
        double belts = Double.parseDouble(scanner.nextLine());
        double oneLightSaberFl = Math.ceil(students * 1.10);
        double freeBelt = students - students / 6;
        double equipPrice = (oneLightSaber * (oneLightSaberFl) + students * robes + belts * freeBelt);
        double finalPrice = 0.0;
        if (equipPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", equipPrice);
        } else {
            money = equipPrice - money;

            System.out.printf("George Lucas will need %.2flv more.", money);
        }

    }
}
