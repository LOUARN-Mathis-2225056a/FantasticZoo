package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aviary extends AbstractEnclosure implements Runnable{
    private float height;

    public Aviary(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList, float height) throws Exception {
        super(name, surface, nbMaxCreature, creatureList);
        this.height = height;
        setEnclosureType("Flyer");
    }
    public Aviary(String name, float surface, int nbMaxCreature, float height) {
        super(name, surface, nbMaxCreature);
        this.height = height;
        setEnclosureType("Flyer");
    }

    @Override
    public void addCreature(Creature creature) {
        if(getNbCurrentCreature()==getNbMaxCreature()){
            System.out.println("This enclosure is already full");
        }
        else if (creature.getInterface().contains("Flyer")){
            if(getAnimalType()!=null){
                if(creature.getClass() == getAnimalType()){
                    creatureList.add(creature);
                    setNbCurrentCreature(getNbCurrentCreature()+1);
                }else {
                    System.out.println("You cannot add this type of creature in this enclosure.");
                }
            } else{
                setAnimalType(creature.getClass());
                creatureList.add(creature);
                setNbCurrentCreature(getNbCurrentCreature()+1);
            }
        } else {
            System.out.println("You cannot add this creature in this type of enclosure.");
        }
    }

    @Override
    public void clean(int cleanlinessLevel) {

    }

    @Override
    public void run() {

    }
}
