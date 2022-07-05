package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String power = scanner.nextLine();
        String suit = scanner.nextLine();
        RankPower rankPower = RankPower.valueOf(power);
        SuitPower suitPower = SuitPower.valueOf(suit);

        System.out.printf("Card name: %s of %s; Card power: %d", power, suit, sum(rankPower, suitPower));
    }

    public static int sum(RankPower rankPower, SuitPower suitPower) {
        int rank = rankPower.getPower();
        int suit = suitPower.getSuit();
        return rank + suit;

    }
}
