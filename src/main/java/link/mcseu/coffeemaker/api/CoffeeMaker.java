package link.mcseu.coffeemaker.api;

import java.io.IOException;

public interface CoffeeMaker {
    public boolean checkForUpdates() throws IOException;
    public void printBuildInformation();
    
    public CoffeeMachine createMachine();
    public Pot createPot();
}