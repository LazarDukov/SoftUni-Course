package CardsWithPower;

public enum SuitPower {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int suit;

    SuitPower(int suit) {
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
}
