package model;

import java.util.ArrayList;

public class Enclosure {
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private String cleanliness = "good";
    private ArrayList<Creature> listeCreature = new ArrayList<>();

    public void addCreature(Creature creature){
        listeCreature.add(creature);
    }

    public void removeCreature(Creature creature){
        listeCreature.remove(creature);
    }

    public void clean(){
        if (cleanliness == "good"){

        }
    }
}

