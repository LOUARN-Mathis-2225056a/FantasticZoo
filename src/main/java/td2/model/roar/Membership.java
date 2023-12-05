package td2.model.roar;

public class Membership extends Roar{
    private int enclosureNum; // knowing that there is only one LycanPack per enclosure then this can correspond to the identity of this one
    private boolean IAmTheFirst; // false = no need respond, true = need respond

    public Membership(int enclosureNum, boolean IAmTheFirst) {
        super(enclosureNum + " AHOOOO !!!");
        this.enclosureNum = enclosureNum;
        this.IAmTheFirst = IAmTheFirst;
    }

}
