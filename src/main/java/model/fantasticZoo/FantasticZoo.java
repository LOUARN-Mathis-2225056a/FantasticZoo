package model.fantasticZoo;

import model.creature.*;
import model.enclosure.*;
import model.zooMaster.ZooMaster;

import java.util.ArrayList;

public class FantasticZoo {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<AbstractEnclosure> listAbstractEnclosures;

    public void main(String[] args){

        // CREATURES
        Dragon drg1 = new Dragon("drg1",false,75,100,1);
        Dragon drg2 = new Dragon("drg2",true,75,100,1);

        Kraken kra1 = new Kraken("kra1",true,2,20,1);
        Kraken kra2 = new Kraken("kra2",true,2,20,1);

        Lycanthrope lyc1 = new Lycanthrope("kra1",false,5,30,1);
        Lycanthrope lyc2 = new Lycanthrope("kra2",false,5,30,1);

        Megalodon meg1 = new Megalodon("meg1",true,4000, 10000,1);
        Megalodon meg2 = new Megalodon("meg2",false,4000, 10000,1);

        Mermaid mer1 = new Mermaid("mer1",false,5,30,1);
        Mermaid mer2 = new Mermaid("mer2",false,5,30,1);

        Nymph nym1 = new Nymph("nym1",true,5,30,1);
        Nymph nym2 = new Nymph("nym2",true,5,30,1);

        Phoenix pho1 = new Phoenix("pho1",true,4,54,1);
        Phoenix pho2 = new Phoenix("pho2",false,4,54,1);

        Unicorn uni1 = new Unicorn("uni1",false,18,100,1);
        Unicorn uni2 = new Unicorn("uni2",true,18,100,1);

        Thread tdrg1 = new Thread(drg1);
        Thread tdrg2 = new Thread(drg2);

        Thread tkra1 = new Thread(kra1);
        Thread tkra2 = new Thread(kra2);

        Thread tlyc1 = new Thread(lyc1);
        Thread tlyc2 = new Thread(lyc2);

        Thread tmer1 = new Thread(mer1);
        Thread tmer2 = new Thread(mer2);

        Thread tnym1 = new Thread(nym1);
        Thread tnym2 = new Thread(nym2);

        Thread tpho1 = new Thread(pho1);
        Thread tpho2 = new Thread(pho2);

        Thread tuni1 = new Thread(uni1);
        Thread tuni2 = new Thread(uni2);

        tdrg1.run();
        tdrg2.run();

        tkra2.run();
        tkra1.run();

        tlyc2.run();
        tlyc1.run();

        tmer2.run();
        tmer1.run();

        tnym2.run();
        tnym1.run();

        tpho2.run();
        tpho1.run();

        tuni2.run();
        tuni1.run();

        

    }
    public void showNBCreature(){
        int count = 0;
        for (AbstractEnclosure abstractEnclosure : listAbstractEnclosures){
            count += abstractEnclosure.getCreatureList().size();
        }
        System.out.println("There is a total die " + count + " in the zooFantastic");
    }

    public void showCreature(){
        for (AbstractEnclosure abstractEnclosure : listAbstractEnclosures){
            for (Creature creature : abstractEnclosure.getCreatureList()){
                creature.toString();
            }
        }
    }
}
