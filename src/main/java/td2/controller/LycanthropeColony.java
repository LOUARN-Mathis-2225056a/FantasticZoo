package td2.controller;

import td2.model.AlphaCouple;
import td2.model.Enclosure2;
import td2.model.LycanPack;
import td2.model.lycan.Lycanthrope2;
import td2.model.lycan.LycanthropeInPack;
import td2.model.lycan.LycanthropeSolitary;
import td2.model.roar.*;

import java.util.ArrayList;
import java.util.Random;

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
        Lycanthrope2 lycanOne = new LycanthropeSolitary(true, Lycanthrope2.AgeCategory.YOUNG,0,encloOne);
        Lycanthrope2 lycanOne2 = new LycanthropeSolitary(false, Lycanthrope2.AgeCategory.YOUNG,0,encloTwo);

        // LycanthropeInPack creation

        LycanthropeInPack lycanTwo = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycanTree = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,1,encloOne.getLycanPack());
        LycanthropeInPack lycan4 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,5,encloOne.getLycanPack());
        LycanthropeInPack lycan5 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,2,encloOne.getLycanPack());


        LycanthropeInPack lycan6 = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,1,encloTwo.getLycanPack());
        LycanthropeInPack lycan7 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,1,encloTwo.getLycanPack());
        LycanthropeInPack lycan8 = new LycanthropeInPack(false, Lycanthrope2.AgeCategory.YOUNG,0,2,encloTwo.getLycanPack());
        LycanthropeInPack lycan9 = new LycanthropeInPack(true, Lycanthrope2.AgeCategory.YOUNG,0,2,encloTwo.getLycanPack());

        // test zone
        AlphaCouple coupleOne = new AlphaCouple(lycanTree,lycanTwo);
        AlphaCouple coupleTwo = new AlphaCouple(lycan7,lycan6);
        encloOne.getLycanPack().setAlphaCouple(coupleOne);
        encloTwo.getLycanPack().setAlphaCouple(coupleTwo);

    }
    private ArrayList<Enclosure2> listEnclosure= new ArrayList<Enclosure2>();
    private Thread thread;
    public LycanthropeColony(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        float time = 0; // 4 seasons per year (0, 0.25, 0.5, 0.75) , season 0.75 is the mating season, every year each lycan can age a little more
        while (true){
            // gestion of time
            time += 0.25;
            if (time == 1){
                time = 0;
            }
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
                            System.out.println("\u001B[34m" + "                                                                      /\\ A new enclosure with a new lycan pack has just been created !! /\\" + "\u001B[0m");
                        }
                        else {
                            System.out.println("\u001B[34m" + "                                                                      /\\ An empty lycan pack just got two new alphas !! /\\" + "\u001B[0m");
                        }
                        male.setEnclosure(enclosureEmpty);
                        female.setEnclosure(enclosureEmpty);
                        male.goInPark();
                        female.goInPark();
                        enclosureEmpty.getLycanPack().setAlphaCouple(new AlphaCouple(enclosureEmpty.getLycanPack().getListLycan().get(0),enclosureEmpty.getLycanPack().getListLycan().get(1)));
                        break;
                    }
                }
            }

            if (time == 0){ //every year we do:
                // aging management
                Random rd = new Random();
                ArrayList<LycanthropeSolitary> growOldSolitaryList = new ArrayList<LycanthropeSolitary>();
                ArrayList<LycanthropeInPack> growOldPackList = new ArrayList<LycanthropeInPack>();
                for (Enclosure2 enclosure : listEnclosure){
                    if (rd.nextInt(5)==0){
                        enclosure.getLycanPack().getAlphaCouple().giveBirth();
                    }
                    for (LycanthropeInPack lycanthropeInPack : enclosure.getLycanPack().getListLycan()){
                        if (rd.nextInt(10) == 0){
                            growOldPackList.add(lycanthropeInPack);/*
                            int rankOfLycanTarget = lycanthropeInPack.getRank();
                            // rank management when lycans have less than 0 dominance
                            if (enclosure.getLycanPack().hasLowerRank(rankOfLycanTarget)) {
                                lycanthropeInPack.setRank(lycanthropeInPack.getRank() + 1);
                                System.out.println("\u001B[34m" + "                                                                      One Lycan lose rank" + "\u001B[0m");
                            }*/
                        }

                    }
                    for (LycanthropeSolitary lycanthropeSolitary : enclosure.getListSolitary()){
                        if (rd.nextInt(10) == 0){
                            growOldSolitaryList.add(lycanthropeSolitary);
                        }
                    }
                }
                for (LycanthropeSolitary lycanthropeSolitary : growOldSolitaryList){
                    lycanthropeSolitary.growOld();
                }
                for (LycanthropeInPack lycanthropeInPack : growOldPackList){
                    lycanthropeInPack.growOld();
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
            if(enclosure.getLycanPack().getListLycan().isEmpty() && enclosure.getListSolitary().isEmpty()){
                System.out.println("\033[0;32m" + " EMPTY ");
            }
            for (LycanthropeInPack lycanthropeInPack : enclosure.getLycanPack().getListLycan()){
                System.out.println(lycanthropeInPack);
            }
            for (LycanthropeSolitary lycanthropeSolitary : enclosure.getListSolitary()){
                System.out.println(lycanthropeSolitary);
            }
        }
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
