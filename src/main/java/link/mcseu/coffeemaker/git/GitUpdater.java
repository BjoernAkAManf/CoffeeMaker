package link.mcseu.coffeemaker.git;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

public class GitUpdater implements Updater {
    @Override
    public boolean updateable(Build build) throws IOException {
        try {
            final Collection<Ref> refs = Git.lsRemoteRepository()
                    .setHeads(true)
                    .setTags(false)
                    .setRemote("https://github.com/BjoernAkAManf/CoffeeMaker.git")
                    .call();

            for (Ref ref : refs) {
                if (matches(build, ref)) {
                    final String remote = ref.getObjectId().getName();
                    return remote.equals(build.getCommit());
                }
            }

            // Branch not found
            return false;
        } catch (GitAPIException ex) {
            throw new IOException(ex);
        }
    }
    
    protected boolean matches(Build build, Ref ref) {
        final String name = ref.getName().replaceAll("^refs/heads/", "");
        return build.getBranch().equals(name);
    }
}