package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aviary extends Enclosure {
    private float height;

    public Aviary(String name, float surface, int nbMaxCreature, ArrayList<Creature> listeCreature, float height) throws Exception {
        super(name, surface, nbMaxCreature, listeCreature);
        this.height = height;
    }

    @Override
    public void addCreature(Creature creature) {
        if(getNbCurrentCreature()==getNbMaxCreature()){
            System.out.println("This enclosure is already full");
        }
        else if (creature.getInterface().contains("Flyer")){
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
