package td1.enclosure;

import td1.creature.Creature;

import java.util.ArrayList;
import java.util.Random;

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

    public Enclosure() {

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
