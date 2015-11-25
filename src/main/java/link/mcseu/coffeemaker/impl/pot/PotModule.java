package link.mcseu.coffeemaker.impl.pot;

import com.google.inject.AbstractModule;
import link.mcseu.coffeemaker.api.Pot;

public class PotModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Pot.class).to(DirtyPot.class);
    }
}