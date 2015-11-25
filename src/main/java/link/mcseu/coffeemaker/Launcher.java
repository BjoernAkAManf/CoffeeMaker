package link.mcseu.coffeemaker;

import java.io.IOException;
import link.mcseu.artifacter.Artifacter;
import link.mcseu.maven.Maven;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.nio.file.Path;
import java.nio.file.Paths;
import link.mcseu.coffeemaker.api.CoffeeMachine;
import link.mcseu.coffeemaker.api.Pot;
import link.mcseu.coffeemaker.git.Build;
import link.mcseu.coffeemaker.git.GitLoader;
import link.mcseu.coffeemaker.impl.machine.MachineModule;
import link.mcseu.coffeemaker.impl.pot.PotModule;

public class Launcher {
    public static final Path LIBRARY = Paths.get("libs");

    public Launcher() throws InterruptedException {
        final Injector injector = Guice
                .createInjector(new MachineModule(), new PotModule());

        final CoffeeMachine machine = injector.getInstance(CoffeeMachine.class);
        final Pot pot = injector.getInstance(Pot.class);

        System.out.println(machine.makeCoffee(pot));
    }
    
    public static void main(String[] args) throws IOException {
        try {
            // Load Dependencies
            Maven.load(Artifacter.main(), LIBRARY);

            // Get Information about Build
            final Build build = GitLoader.create(Launcher.class);

            // TODO: Check for Updates
            System.out.println(build.getCommit() + " " + build.getCommiterEmail());
            
            new Launcher();
        } catch (InterruptedException ex) {
            throw new IOException(ex);
        }
    }
}