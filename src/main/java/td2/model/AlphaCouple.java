package td2.model;

import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeInPack;
import java.util.Random;

public class AlphaCouple {

    LycanthropeInPack male;
    LycanthropeInPack female;

    public AlphaCouple(LycanthropeInPack male, LycanthropeInPack female) {
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

    public void giveBirth(){
        Random rd = new Random();
        int nbBaby = rd.nextInt(7);
        for (int i = 0; i <= nbBaby; ++i){
            LycanthropeInPack newLycan = new LycanthropeInPack(rd.nextBoolean(),
                                                Lycanthrope2.AgeCategory.YOUNG,
                                                rd.nextInt(5),0,0,0,"XXX",female.getLycanPack());
        }
    }
}
