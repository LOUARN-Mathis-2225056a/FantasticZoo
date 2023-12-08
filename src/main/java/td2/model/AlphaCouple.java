package td2.model;

import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeInPack;
import java.util.Random;

public class AlphaCouple {

    private LycanthropeInPack male;
    private LycanthropeInPack female;

    public AlphaCouple(LycanthropeInPack male, LycanthropeInPack female) {
        this.male = male;
        this.female = female;
    }

    public LycanthropeInPack getMale() {
        return male;
    }

    public void setMale(LycanthropeInPack male) {
        this.male = male;
    }

    public LycanthropeInPack getFemale() {
        return female;
    }

    public void setFemale(LycanthropeInPack female) {
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
        if (male != null && female != null){
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
            System.out.println("\u001B[35m                                                                      "
                    + (nbBaby +1)  + " lycans just born in the enclosure " + male.getLycanPack().getEnclosure().getID()
                    + "                                                                          "
                    + "Total Lycan in colony : " + male.getLycanPack().getEnclosure().getLycanthropeColony().getTotalLycanInColony()
                    + "\u001B[0m");
        }
        else{
            String errorCause;
            if(male == null && female == null){
                errorCause = "both are null";
            } else if (male == null){
                errorCause = "male is null";
            } else {
                errorCause = "female is null";
            }
            System.out.println("                                                                                                                                            "+
                    "This couple can't give birt ! Cause : " + errorCause);
        }

    }
}
