package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Enclosure {
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private String cleanliness = "good";
    private ArrayList<Creature> listeCreature = new ArrayList<>();

    public Enclosure(String name, float surface, int nbMaxCreature){
        this.name = name;
        this.surface = surface;
        this. nbMaxCreature = nbMaxCreature;
        nbCurrentCreature = 0;
        listeCreature = new ArrayList<>();
    }
    public Enclosure(String name, float surface, int nbMaxCreature, ArrayList<Creature> listeCreature){
        this.name = name;
        this.surface = surface;
        this. nbMaxCreature = nbMaxCreature;
        this.listeCreature = listeCreature;
        nbCurrentCreature = listeCreature.size();
    }
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

