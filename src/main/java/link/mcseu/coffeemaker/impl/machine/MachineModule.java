package link.mcseu.coffeemaker.impl.machine;

import com.google.inject.AbstractModule;
import link.mcseu.coffeemaker.api.CoffeeMachine;

public class MachineModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CoffeeMachine.class).to(SimpleCoffeeMachine.class);
    }
}