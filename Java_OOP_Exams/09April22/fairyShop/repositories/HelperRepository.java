package fairyShop.repositories;

import fairyShop.models.helpers.BaseHelper;

import fairyShop.models.helpers.Helper;
import fairyShop.models.instruments.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
    private Collection<Helper> helpers;

    public HelperRepository(Collection<BaseHelper> helpers) {
        this.helpers = new ArrayList<>();

    }


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper helper) {
        helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        if (helpers.contains(helper)) {
            helpers.remove(helper);
            return true;
        }
        return false;
    }

    @Override
    public Helper findByName(String name) {
        Helper helper = null;
        for (Helper b : helpers) {
            if (b.getName().equals(name)) {
                helper = b;
                return helper;
            }
        }
        return helper;
    }
}
