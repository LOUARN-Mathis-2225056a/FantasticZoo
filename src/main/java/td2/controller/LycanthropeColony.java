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

import java.util.ArrayList;

public class LycanthropeColony {
    private ArrayList<Enclosure2> listEnclosure= new ArrayList<Enclosure2>();
    static public void main(String[] arg){

        // colony creation
        LycanthropeColony lycanthropeColony = new LycanthropeColony();

        // enclosure creation
        Enclosure2 encloOne = new Enclosure2();

        // enclosure in colony
        lycanthropeColony.addEnclosure(encloOne);

        // LycanthropeSolitary creation
        Lycanthrope2 lycanOne = new LycanthropeSolitary(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,encloOne);

        // LycanthropeInPack creation

        LycanthropeInPack lycanTwo = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycanTree = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycan4 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,5,encloOne.getLycanPack());
        LycanthropeInPack lycan5 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloOne.getLycanPack());

        // test zone
        AlphaCouple coupleOne = new AlphaCouple(lycanTree,lycanTwo);
        encloOne.getLycanPack().setAlphaCouple(coupleOne);
        coupleOne.giveBirth();
        coupleOne.giveBirth();
        encloOne.getLycanPack().showToString();
        lycanthropeColony.showAllLycan();
    }

    public void addEnclosure(Enclosure2 enclosure){listEnclosure.add(enclosure);}

    public void showAllLycan(){
        System.out.println("\u001B[32m" + "ALL LYCANTHROPE IN COLONY : ");
        for (Enclosure2 enclosure : listEnclosure){
            for (LycanthropeInPack lycanthropeInPack : enclosure.getLycanPack().getListLycan()){
                System.out.println(lycanthropeInPack);
            }
            for (LycanthropeSolitary lycanthropeSolitary : enclosure.getListSolitary()){
                System.out.println(lycanthropeSolitary);
            }
        }
    }
}
