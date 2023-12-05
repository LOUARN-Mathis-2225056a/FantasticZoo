package td1.enclosure;

import td1.creature.Creature;

import java.util.ArrayList;
import java.util.Random;

public class Enclosure extends AbstractEnclosure{

    public Enclosure(String name, float surface, int nbMaxCreature) {
        super(name,surface,nbMaxCreature);
        creatureList = new ArrayList<>();
        type = "Runner";
    }

    public Enclosure(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList) throws Exception {
        super(name, surface, nbMaxCreature, creatureList);
        type = "Runner";
    }

    public Enclosure() {

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
