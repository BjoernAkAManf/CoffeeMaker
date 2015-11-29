package link.mcseu.coffeemaker.impl.machine;

import com.google.auto.service.AutoService;
import java.util.concurrent.TimeUnit;
import link.mcseu.coffeemaker.api.CoffeeMachine;
import link.mcseu.coffeemaker.api.Pot;

@AutoService(CoffeeMachine.class)
public class SimpleCoffeeMachine implements CoffeeMachine {
    @Override
    public boolean makeCoffee(Pot pot) throws InterruptedException {
        System.out.println("MAKING...");
        int i = 10;
        while(i-- > 0) {
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            
            if(i % 5 ==0 ) System.out.println();
        }
        
        System.out.println("Ready: " + pot.getName());
        
        return true;
    }
}