package link.mcseu.coffeemaker.impl.pot;

import link.mcseu.coffeemaker.api.Pot;

class DirtyPot implements Pot {
    @Override
    public String getName() {
        return "My Favorite Pot";
    }
}