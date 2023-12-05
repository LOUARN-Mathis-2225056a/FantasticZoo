package td2.controller;

import td2.model.LycanPack;
import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeEnMeute;

public class LycanthropeColony {
    static public void main(String[] arg){
        Lycanthrope2 lycanOne = new Lycanthrope2(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0);
        lycanOne.ShowToString();
        LycanPack lycanPackOne = new LycanPack();
        Lycanthrope2 lycanTwo = new LycanthropeEnMeute(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,"Alpha",lycanPackOne);
        lycanTwo.ShowToString();
    }
}
