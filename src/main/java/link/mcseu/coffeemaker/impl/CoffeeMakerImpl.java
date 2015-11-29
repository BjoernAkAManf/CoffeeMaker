package link.mcseu.coffeemaker.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ServiceLoader;
import link.mcseu.coffeemaker.api.CoffeeMachine;
import link.mcseu.coffeemaker.api.CoffeeMaker;
import link.mcseu.coffeemaker.api.Pot;
import link.mcseu.updater.api.Build;
import link.mcseu.updater.api.Updater;

public class CoffeeMakerImpl implements CoffeeMaker {
    public static final Path LIBRARY = Paths.get("libs");
    private final Injector injector;

    public CoffeeMakerImpl() {
        this.injector = Guice
                .createInjector(ServiceLoader.load(Module.class));
    }
    
    @Override
    public CoffeeMachine createMachine() {
        return injector.getInstance(CoffeeMachine.class);
    }
    
    @Override
    public Pot createPot() {
        return injector.getInstance(Pot.class);
    }
    
    @Override
    public boolean checkForUpdates() throws IOException {
        return injector.getInstance(Updater.class)
                .updateable();
    }

    @Override
    public void printBuildInformation() {
        // Get Information about Build
        final Build build = injector.getInstance(Build.class);

        // TODO: Check for Updates
        System.out.println(build.getCommit() + " " + build.getCommiterEmail());
    }
}