package fairyShop.models.helpers;

public class Sleepy extends BaseHelper {
    private static final int ENERGY = 50;

    public Sleepy(String name, int energy) {
        super(name, ENERGY);
    }

    @Override
    public void work() {
        if (getEnergy() - 15 <= 0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 15);
        }
    }
}
