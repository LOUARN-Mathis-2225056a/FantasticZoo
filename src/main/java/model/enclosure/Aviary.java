package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;
import java.util.Random;

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
        int sleepTime;
        while (getHp()>0){
            Random rng = new Random();
            if(rng.nextInt(1000)<getNbCurrentCreature()){ /* the more creature there are in the enclosure, the easier it is to lose cleanliness level */
                setCleanlinessLevel(getCleanlinessLevel()-1);
                if(getCleanlinessLevel()<0){ /* if cleanliness level is below 0 the enclosure will lose hp based on the number of cleanliness level below 0 */
                    setHp(getHp()-getCleanlinessLevel());
                }
            }
            sleepTime = (rng.nextInt(5)+10)*1000;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
