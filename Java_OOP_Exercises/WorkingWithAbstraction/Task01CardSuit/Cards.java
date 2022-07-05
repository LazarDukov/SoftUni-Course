package CardSuit;

public enum Cards {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    private int value;

    Cards(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
