package model.zooFantastique;

import model.creature.Creature;
import model.enclosure.*;
import model.zooMaster.ZooMaster;

import java.util.ArrayList;

public class ZooFantastic {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<Enclosure> listEnclosures;

    public void main(String[] args){

    }
    private void showNBCreature(){
        int count = 0;
        for (Enclosure enclosure : listEnclosures){
            count += enclosure.getListeCreature().size();
        }
        System.out.println("There is a total die " + count + " in the zooFantastic");
    }

    private void showCreature(){
        for (Enclosure enclosure : listEnclosures){
            for (Creature creature : enclosure.getListeCreature()){
                creature.toString();
            }
        }
    }


}
