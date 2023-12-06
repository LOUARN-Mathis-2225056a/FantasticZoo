package td2.controller;

import td2.model.AlphaCouple;
import td2.model.Enclosure2;
import td2.model.LycanPack;
import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeEnMeute;
import td2.model.lycan.LycanthropeSolitary;
import td2.model.roar.Aggressiveness;
import td2.model.roar.Domination;
import td2.model.roar.Membership;
import td2.model.roar.Submission;

public class LycanthropeColony {
    static public void main(String[] arg){
        Enclosure2 encloOne = new Enclosure2();
        Lycanthrope2 lycanOne = new LycanthropeSolitary(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,encloOne);
        lycanOne.ShowToString();
        LycanPack lycanPackOne = new LycanPack(encloOne);
        LycanthropeEnMeute lycanTwo = new LycanthropeEnMeute(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,"Alpha",lycanPackOne);
        LycanthropeEnMeute lycanTree = new LycanthropeEnMeute(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,"Alpha",lycanPackOne);
        AlphaCouple coupleOne = new AlphaCouple(lycanTree,lycanTwo);
        lycanTwo.ShowToString();
        coupleOne.showToString();

        lycanTwo.emitHowl(new Membership(true));
        lycanTwo.emitHowl(new Submission());
        lycanTwo.emitHowl(new Aggressiveness());
        lycanTwo.emitHowl(new Domination(lycanOne));
        lycanTwo.leaveLycanPack();


    }
}
