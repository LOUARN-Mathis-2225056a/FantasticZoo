package td1.model.enclosure;

import java.util.Random;

public class Aviary extends AbstractEnclosure implements Runnable{
    private final float height;
    private int roofCleanliness = 3;

    public Aviary(String name, float surface, int nbMaxCreature, float height) {
        super(name, surface, nbMaxCreature);
        this.height = height;
        type = "Flyer";
    }

    /**
     * Cleans the roof of the aviary
     */
    public void cleanRoof() {
        System.out.println("You check the roof's cleanliness ");
        roofCleanliness+=2;
        if(roofCleanliness>3){
            roofCleanliness = 3;
        }
    }

    /**
     * Defines how the enclosure evolves through time.
     * Is used by threads
     *
     * @throws RuntimeException
     */
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

    @Override
    public String toString() {
        return (super.toString() + "\n height : " + height);
    }
}
