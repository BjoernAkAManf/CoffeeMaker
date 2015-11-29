package link.mcseu.coffeemaker;

import java.io.IOException;
import link.mcseu.artifacter.Artifacter;
import link.mcseu.maven.Maven;

import link.mcseu.coffeemaker.api.CoffeeMachine;
import link.mcseu.coffeemaker.api.CoffeeMaker;
import link.mcseu.coffeemaker.api.Pot;
import link.mcseu.coffeemaker.impl.CoffeeMakerImpl;

public class Launcher {
    public static void main(String[] args) throws IOException {
        try {
            // Load Dependencies
            Maven.load(Artifacter.main(), CoffeeMakerImpl.LIBRARY);

            final CoffeeMaker maker = new CoffeeMakerImpl();
            maker.printBuildInformation();

            if (maker.checkForUpdates()) {
                System.out.println("Running latest Version");
            } else {
                System.out.println("Running old Version");
            }
            
            final CoffeeMachine machine = maker.createMachine();
            final Pot pot = maker.createPot();
            System.out.println(machine.makeCoffee(pot));
        } catch (InterruptedException ex) {
            throw new IOException(ex);
        }
    }
}