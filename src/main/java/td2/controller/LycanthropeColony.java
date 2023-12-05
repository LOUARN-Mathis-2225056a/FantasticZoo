package td2.controller;

import td2.model.Enclosure2;
import td2.model.LycanPack;
import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeEnMeute;
import td2.model.roar.Aggressiveness;
import td2.model.roar.Domination;
import td2.model.roar.Membership;
import td2.model.roar.Submission;

public class LycanthropeColony {
    static public void main(String[] arg){
        Lycanthrope2 lycanOne = new Lycanthrope2(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0);
        lycanOne.ShowToString();
        Enclosure2 encloOne = new Enclosure2();
        LycanPack lycanPackOne = new LycanPack(encloOne);
        LycanthropeEnMeute lycanTwo = new LycanthropeEnMeute(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,"Alpha",lycanPackOne);
        lycanTwo.ShowToString();

        lycanTwo.emitHowl(new Membership(true));
        lycanTwo.emitHowl(new Submission());
        lycanTwo.emitHowl(new Aggressiveness());
        lycanTwo.emitHowl(new Domination(lycanOne));
        lycanTwo.leaveLycanPack();
    }
}
