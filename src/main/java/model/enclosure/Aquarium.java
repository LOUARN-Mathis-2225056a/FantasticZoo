package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aquarium extends Enclosure {
    private float depht;
    private int salinity;

    public Aquarium(String name, float surface, int nbMaxCreature, ArrayList<Creature> listeCreature, float depht, int salinity) throws Exception {
        super(name, surface, nbMaxCreature, listeCreature);
        this.depht = depht;
        this.salinity = salinity;
    }
    public Aquarium(String name, float surface, int nbMaxCreature, float depht, int salinity) throws Exception {
        super(name, surface, nbMaxCreature);
        this.depht = depht;
        this.salinity = salinity;
    }

    public void addCreature(Creature creature){
        if(getNbCurrentCreature()==getNbMaxCreature()){
            System.out.println("This enclosure is already full");
        }
        else if (creature.getInterface().contains("Swimmer")){
            creatureList.add(creature);
            setNbCurrentCreature(getNbCurrentCreature()+1);
        }
        else{
            System.out.println("You cannot add this creature in this type of enclosure.");
        }
    }

    @Override
    public void clean() {
        /*code*/
    }
}
