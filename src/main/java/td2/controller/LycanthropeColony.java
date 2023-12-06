package td2.controller;

import td2.model.AlphaCouple;
import td2.model.Enclosure2;
import td2.model.LycanPack;
import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeInPack;
import td2.model.lycan.LycanthropeSolitary;
import td2.model.roar.Aggressiveness;
import td2.model.roar.Domination;
import td2.model.roar.Membership;
import td2.model.roar.Submission;

public class LycanthropeColony {
    static public void main(String[] arg){
        Enclosure2 encloOne = new Enclosure2();
        Lycanthrope2 lycanOne = new LycanthropeSolitary(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,encloOne);
        LycanPack lycanPackOne = new LycanPack(encloOne);
        LycanthropeInPack lycanTwo = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,lycanPackOne);
        LycanthropeInPack lycanTree = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,lycanPackOne);
        LycanthropeInPack lycan4 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,5,lycanPackOne);
        LycanthropeInPack lycan5 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,lycanPackOne);
        AlphaCouple coupleOne = new AlphaCouple(lycanTree,lycanTwo);
        lycanPackOne.setAlphaCouple(coupleOne);
        coupleOne.giveBirth();
        coupleOne.giveBirth();
        lycanPackOne.showToString();
    }
}
