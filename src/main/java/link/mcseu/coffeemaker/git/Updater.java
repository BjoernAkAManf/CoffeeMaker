package link.mcseu.coffeemaker.git;

import java.io.IOException;

public interface Updater {
    public boolean updateable(Build build) throws IOException;
}