package link.mcseu.coffeemaker.api;

public interface CoffeeMachine {
    public boolean makeCoffee(Pot pot) throws InterruptedException;
}