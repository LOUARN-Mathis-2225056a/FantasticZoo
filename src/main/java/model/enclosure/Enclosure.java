package model.enclosure;

import model.creature.Creature;
import model.creature.Swimmer;

import java.util.ArrayList;
import java.util.Arrays;

public class Enclosure {
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private String cleanliness = "good";
    private String type = "";
    protected ArrayList<Creature> creatureList = new ArrayList<>();

    public Enclosure(String name, float surface, int nbMaxCreature){
        this.name = name;
        this.surface = surface;
        this. nbMaxCreature = nbMaxCreature;
        nbCurrentCreature = 0;
        creatureList = new ArrayList<>();
        type = "Runner";
    }
    public Enclosure(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList) throws Exception {
        if(creatureList.size() > nbMaxCreature){
            throw new Exception("The provided creature list contains more creature than the maximum acceptable.");
        }
        else{
            this.name = name;
            this.surface = surface;
            this. nbMaxCreature = nbMaxCreature;
            this.creatureList = creatureList;
            nbCurrentCreature = creatureList.size();
            type = "Runner";
        }
    }
    public void addCreature(Creature creature) {
            if(nbCurrentCreature==nbMaxCreature){
                System.out.println("This enclosure is already full");
            }
            else if (creature.getInterface().contains("Runner")){
                creatureList.add(creature);
                ++nbCurrentCreature;
            }
            else{
                System.out.println("You cannot add this creature in this type of enclosure.");
            }
    }

    public void removeCreature(Creature creature){
        creatureList.remove(creature);
        --nbCurrentCreature;
    }

    public void clean(){
        if (cleanliness == "good"){

        }
    }

    public ArrayList<Creature> getCreatureList() {
        return creatureList;
    }
    public int getNbCurrentCreature(){
        return nbCurrentCreature;
    }
    public int getNbMaxCreature(){
        return nbMaxCreature;
    }
    public void setNbCurrentCreature(int value){
        nbCurrentCreature = value;
    }

}

