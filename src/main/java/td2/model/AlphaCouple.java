package td2.model;

import td2.model.lycan.LycanthropeEnMeute;

public class AlphaCouple {

    LycanthropeEnMeute male;
    LycanthropeEnMeute female;

    public AlphaCouple(LycanthropeEnMeute male, LycanthropeEnMeute female) {
        this.male = male;
        this.female = female;
    }

    @Override
    public String toString() {
        return "ALPHA COUPLE : \n"
                + "--MALE--\n"
                + male
                + "--FEMALE--\n"
                +female;
    }
    public void showToString(){System.out.println(this);}
}
