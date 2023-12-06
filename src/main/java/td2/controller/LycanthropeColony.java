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

public class LycanthropeColony implements Runnable{
    static public void main(String[] arg){

        // colony creation
        LycanthropeColony lycanthropeColony = new LycanthropeColony();

        // enclosure creation
        Enclosure2 encloOne = new Enclosure2();
        Enclosure2 encloTwo = new Enclosure2();
        Enclosure2 encloTree = new Enclosure2();

        // enclosure in colony
        lycanthropeColony.addEnclosure(encloOne);
        lycanthropeColony.addEnclosure(encloTwo);
        lycanthropeColony.addEnclosure(encloTree);

        // LycanthropeSolitary creation
        Lycanthrope2 lycanOne = new LycanthropeSolitary(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,encloOne);
        Lycanthrope2 lycanOne2 = new LycanthropeSolitary(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,encloTwo);

        // LycanthropeInPack creation

        LycanthropeInPack lycanTwo = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycanTree = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycan4 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,5,encloOne.getLycanPack());
        LycanthropeInPack lycan5 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloOne.getLycanPack());


        LycanthropeInPack lycan6 = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloTwo.getLycanPack());
        LycanthropeInPack lycan7 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloTwo.getLycanPack());
        LycanthropeInPack lycan8 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloTwo.getLycanPack());
        LycanthropeInPack lycan9 = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,0,0,0,2,encloTwo.getLycanPack());

        // test zone
        AlphaCouple coupleOne = new AlphaCouple(lycanTree,lycanTwo);
        /*encloOne.getLycanPack().setAlphaCouple(coupleOne);
        coupleOne.giveBirth();
        coupleOne.giveBirth();
        encloOne.getLycanPack().showToString();
        lycanthropeColony.showAllLycan();*/
    }
    private ArrayList<Enclosure2> listEnclosure= new ArrayList<Enclosure2>();
    private Thread thread;
    public LycanthropeColony(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (true){
            // possibility of creating a new colony
            ArrayList<LycanthropeSolitary> listLycanSolitary = getAllLycanSolitary();
            if (listLycanSolitary.size() > 1){
                LycanthropeSolitary male = null;
                LycanthropeSolitary female = null;
                for (LycanthropeSolitary lycanthropeSolitary : listLycanSolitary){
                    if (male == null && !lycanthropeSolitary.isSex()){
                        male = lycanthropeSolitary;
                    }
                    if (female == null && lycanthropeSolitary.isSex()){
                        female = lycanthropeSolitary;
                    }
                    if (female != null && male != null){
                        Enclosure2 enclosureEmpty = giveEmptyEnclosure();
                        if (enclosureEmpty == null) {
                            enclosureEmpty = new Enclosure2();
                            this.addEnclosure(enclosureEmpty);
                            System.out.println("\u001B[34m" + "/\\ A new enclosure with a new lycan pack has just been created !! /\\");
                        }
                        else {
                            System.out.println("\u001B[34m" + "/\\ An empty lycan pack just got two new alphas !! /\\");
                        }
                        male.setEnclosure(enclosureEmpty);
                        female.setEnclosure(enclosureEmpty);
                        male.goInPark();
                        female.goInPark();
                        break;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addEnclosure(Enclosure2 enclosure){listEnclosure.add(enclosure);}
    public Enclosure2 giveEmptyEnclosure(){
        for (Enclosure2 enclosure : listEnclosure){
            if (enclosure.getLycanPack().getListLycan().isEmpty()){
                return enclosure;
            }
        }
        return null;
    }

    public void showAllLycan(){
        System.out.println("\u001B[32m" + "ALL LYCANTHROPE IN COLONY : ");
        for (Enclosure2 enclosure : listEnclosure){
            System.out.println("\u001B[33m" + "Enclosure n°" + enclosure.getID());
            for (LycanthropeInPack lycanthropeInPack : enclosure.getLycanPack().getListLycan()){
                System.out.println(lycanthropeInPack);
            }
            for (LycanthropeSolitary lycanthropeSolitary : enclosure.getListSolitary()){
                System.out.println(lycanthropeSolitary);
            }
        }
    }
    public void changeEnclosureLycanSolitary(LycanthropeSolitary lycanthropeSolitary, Enclosure2 newEnclosure){
        Enclosure2 oldEnclosure = lycanthropeSolitary.getEnclosure();
        oldEnclosure.removeLycanSolitary(lycanthropeSolitary);
        lycanthropeSolitary.setEnclosure(newEnclosure);
    }
    public ArrayList<LycanthropeSolitary> getAllLycanSolitary(){
        ArrayList<LycanthropeSolitary> lisLycanSolitary = new ArrayList<LycanthropeSolitary>();
        for (Enclosure2 enclosure : listEnclosure){
            for (LycanthropeSolitary lycanthropeSolitary : enclosure.getListSolitary()){
                lisLycanSolitary.add(lycanthropeSolitary);
            }
        }
        return lisLycanSolitary;
    }
}
