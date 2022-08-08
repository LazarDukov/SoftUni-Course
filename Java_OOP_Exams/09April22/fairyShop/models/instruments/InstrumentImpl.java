package fairyShop.models.instruments;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    public void setPower(int power) {
        if (getPower() < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        if (getPower() - 10 < 0) {
            setPower(0);
        } else {
            setPower(getPower() - 10);
        }
    }

    @Override
    public boolean isBroken() {
        if (getPower() == 0) {
            return true;
        }
        return false;
    }
}
