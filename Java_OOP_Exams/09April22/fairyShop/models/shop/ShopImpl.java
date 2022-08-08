package fairyShop.models.shop;

import fairyShop.models.helpers.Helper;
import fairyShop.models.instruments.Instrument;
import fairyShop.models.presents.Present;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument i : helper.getInstruments()) {

            while (!(i.isBroken() && !present.isDone())) {

                present.getCrafted();
                helper.work();
                i.use();

                if (!helper.canWork()) {
                    return;
                }
            }
        }
    }


}
