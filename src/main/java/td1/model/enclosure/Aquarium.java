package td1.model.enclosure;

import java.util.Random;

public class Aquarium extends AbstractEnclosure {
    private float depth;
    private int salinity;

    public Aquarium(String name, float surface, int nbMaxCreature, float depth, int salinity) {
        super(name, surface, nbMaxCreature);
        this.depth = depth;
        this.salinity = salinity;
        type = "Swimmer";
    }

    /**
     * Returns the salinity of the enclosure
     *
     * @return the salinity of the enclosure
     */
    public int getSalinity() {
        return salinity;
    }

    /**
     * Sets the salinity of the enclosure
     *
     * @param salinity the salinity of the enclosure
     */
    public void setSalinity(int salinity) {
        this.salinity = salinity;
    }

    public void clean() {
        System.out.println("You check the aquarium's depth and salinity !");
        System.out.println("Depth : " + depth + "\nSalinity : " + salinity);
        super.clean();
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
            if(rng.nextInt(100)<10){
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
    @Override
    public String toString() {
        return (super.toString() + "\n salinity : " + salinity + "\n depth : " + depth);
    }
}
