package link.mcseu.coffeemaker.git;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GitLoader implements Build {
    private final Properties handle;
    
    private GitLoader(Properties handle) throws IOException {
        this.handle = handle;
    }

    @Override
    public boolean isDirty() {
        return get("git.dirty")
                .equalsIgnoreCase("true");
    }
    
    @Override
    public String getCommit() {
        return get("git.commit.id.full");
    }
    
    @Override
    public String getCommiterEmail() {
        return get("git.commit.user.email");
    }
    
    @Override
    public String getCommiterName() {
        return get("git.commit.user.name");
    }
    
    // TODO: Preconditions
    private String get(String key) {
        return handle.getProperty(key);
    }
    
    public static Build create(Class<?> c) throws IOException {
        return create(c.getResourceAsStream("/git.properties"));
    }
    
    public static Build create(InputStream is) throws IOException {
        final Properties p = new Properties();
        p.load(is);
        return new GitLoader(p);
    }
}