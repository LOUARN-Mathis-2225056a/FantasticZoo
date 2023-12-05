package td2.model.roar;

public class Membership extends Roar{
    private int enclosureNum; // knowing that there is only one LycanPack per enclosure then this can correspond to the identity of this one
    private String whatISay;
    private boolean IAmTheFirst; // false = no need respond, true = need respond

    public Membership(int enclosureNum, boolean IAmTheFirst) {
        this.enclosureNum = enclosureNum;
        this.whatISay = enclosureNum + " AHOOOO !!!";
        this.IAmTheFirst = IAmTheFirst;
    }

    public String getWhatISay() {
        return whatISay;
    }
}
