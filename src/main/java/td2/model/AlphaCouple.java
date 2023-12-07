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
        return "\u001B[32m" + "ALPHA COUPLE : \n" + "\u001B[0m"
               +"\u001B[33m" + "    --MALE--\n" + "\u001B[0m"
                + male
                +"\u001B[33m" + "    --FEMALE--\n"+ "\u001B[0m"
                +female;
    }
    public void showToString(){System.out.println(this);}

    public void giveBirth(){
        Random rd = new Random();
        int nbBaby = rd.nextInt(7);
        int newRank;
        if (male.getLycanPack().haveBeta()){
            newRank = 3;
        }
        else {
            newRank = 2;
        }
        for (int i = 0; i <= nbBaby; ++i){
            LycanthropeInPack newLycan = new LycanthropeInPack(rd.nextBoolean(),
                                                Lycanthrope2.AgeCategory.YOUNG,0,newRank,female.getLycanPack());
        }
    }
}
