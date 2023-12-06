package td1.model.enclosure;

import td1.model.creature.Creature;

import java.util.ArrayList;
import java.util.Random;

public class Aquarium extends AbstractEnclosure {
    private float depht = 0;
    private int salinity;

    public Aquarium(String name, float surface, int nbMaxCreature, float depht, int salinity) {
        super(name, surface, nbMaxCreature);
        this.depht = depht;
        this.salinity = salinity;
        type = "Swimmer";
    }

    public Aquarium() {
        super();
    }

    @Override
    public void clean(int cleanlinessLevel) {
    }

    public int getSalinity() {
        return salinity;
    }

    public void setSalinity(int salinity) {
        this.salinity = salinity;
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
            if(rng.nextInt(100)<40){
                if(rng.nextInt(10)%2==0){setSalinity(getSalinity()+5);}
                else {setSalinity(getSalinity()-5);}
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
