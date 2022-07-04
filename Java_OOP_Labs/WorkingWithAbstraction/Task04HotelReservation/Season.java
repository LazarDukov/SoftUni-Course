package HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);


    private int multi;

    Season(int multi) {
        this.multi = multi;
    }

    public int getMulti() {
        return multi;
    }

    public void setMulti(int multi) {
        this.multi = multi;
    }
}