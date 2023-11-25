package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Enclosure extends AbstractEnclosure{

    public Enclosure(String name, float surface, int nbMaxCreature) {
        super(name,surface,nbMaxCreature);
        creatureList = new ArrayList<>();
        setEnclosureType("Runner");
    }

    public Enclosure(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList) throws Exception {
        super(name, surface, nbMaxCreature, creatureList);
        setEnclosureType("Runner");
    }


    @Override
    public void addCreature(Creature creature){
        if (getNbCurrentCreature() == getNbMaxCreature()) {
            System.out.println("This enclosure is already full");
        } else if (creature.getInterface().contains("Runner") || creature.getInterface().contains("none")) {
            if(getNbCurrentCreature()!=0){
                if(creature.getClass() == getAnimalType()){
                    creatureList.add(creature);
                    setNbCurrentCreature(getNbCurrentCreature()+1);
                }else {
                    System.out.println("You cannot add this type of creature in this enclosure.");
                }
            }
            else{
                setAnimalType(creature.getClass());
                creatureList.add(creature);
                setNbCurrentCreature(getNbCurrentCreature()+1);
            }
        } else {
            System.out.println("You cannot add this creature in this type of enclosure.");
        }
    }
}
