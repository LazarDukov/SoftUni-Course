package Inheritance;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(13);
        randomArrayList.add(42);
        randomArrayList.add(69);
        randomArrayList.add(73);
        System.out.println(randomArrayList.getRandomElement());

    }
}
