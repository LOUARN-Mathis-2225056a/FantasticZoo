package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aquarium extends AbstractEnclosure {
    private final float depht;
    private int salinity;

    public Aquarium(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList, float depht, int salinity) throws Exception {
        super(name, surface, nbMaxCreature, creatureList);
        this.depht = depht;
        this.salinity = salinity;
        setEnclosureType("Swimmer");
    }
    public Aquarium(String name, float surface, int nbMaxCreature, float depht, int salinity) {
        super(name, surface, nbMaxCreature);
        this.depht = depht;
        this.salinity = salinity;
        setEnclosureType("Swimmer");
    }
    @Override
    public void addCreature(Creature creature){
        if(getNbCurrentCreature()==getNbMaxCreature()){
            System.out.println("This enclosure is already full");
        }
        else if (creature.getInterface().contains("Swimmer")){
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
}
