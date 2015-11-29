package link.mcseu.coffeemaker.impl.pot;

import com.google.auto.service.AutoService;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import link.mcseu.coffeemaker.api.Pot;

@AutoService(Module.class)
public class PotModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Pot.class).to(DirtyPot.class);
    }
}