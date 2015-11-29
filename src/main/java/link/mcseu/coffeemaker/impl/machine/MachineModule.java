package link.mcseu.coffeemaker.impl.machine;

import com.google.auto.service.AutoService;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import link.mcseu.coffeemaker.api.CoffeeMachine;

@AutoService(Module.class)
public class MachineModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CoffeeMachine.class).to(SimpleCoffeeMachine.class);
    }
}