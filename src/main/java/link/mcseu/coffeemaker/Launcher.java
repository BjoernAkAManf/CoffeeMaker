package link.mcseu.coffeemaker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import link.mcseu.artifacter.Artifacter;
import link.mcseu.maven.Maven;

import com.google.inject.Guice;
import com.google.inject.Injector;
import link.mcseu.coffeemaker.api.CoffeeMachine;
import link.mcseu.coffeemaker.api.Pot;
import link.mcseu.coffeemaker.impl.machine.MachineModule;
import link.mcseu.coffeemaker.impl.pot.PotModule;

public class Launcher {
    public static void main(String[] args) throws InterruptedException, IOException, ReflectiveOperationException {
        final Path p = new File("/home/user/Schreibtisch/A/lib").toPath();
        Maven.load(Artifacter.main(), p);
                System.out.println(RealLauncher.class.getClassLoader());
        
        final Injector injector = Guice.createInjector(new MachineModule(), new PotModule());
        
        final CoffeeMachine machine = injector.getInstance(CoffeeMachine.class);
        final Pot pot = injector.getInstance(Pot.class);
        
        System.out.println(machine.makeCoffee(pot));
    }
}