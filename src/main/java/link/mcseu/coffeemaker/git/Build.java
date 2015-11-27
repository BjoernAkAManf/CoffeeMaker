package link.mcseu.coffeemaker.git;

public interface Build {
    public boolean isDirty();

    public String getBranch();
    public String getCommit();
    
    public String getCommiterName();
    public String getCommiterEmail();
}