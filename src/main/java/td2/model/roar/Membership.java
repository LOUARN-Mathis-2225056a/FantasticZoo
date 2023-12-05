package td2.model.roar;

public class Membership extends Roar{
    private boolean IAmTheFirst; // false = no need respond, true = need respond

    public Membership(boolean IAmTheFirst) {
        super("AHOOOO !!!");
        this.IAmTheFirst = IAmTheFirst;
    }

    public  Membership(){
        super("AHOOOO !!!");
        this.IAmTheFirst = IAmTheFirst;
    }

    public boolean isIAmTheFirst() {
        return IAmTheFirst;
    }

    public void setIAmTheFirst(boolean IAmTheFirst) {
        this.IAmTheFirst = IAmTheFirst;
    }
}
