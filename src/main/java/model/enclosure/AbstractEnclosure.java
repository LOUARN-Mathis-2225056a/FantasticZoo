package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public abstract class AbstractEnclosure implements Runnable{
    protected ArrayList<Creature> creatureList = new ArrayList<>();
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private int cleanlinessLevel = 3;
    private String type = "";
    private Object animalType = null;
    private Thread life = new Thread(this);
    private int hp = 100;
    private int foodMeter;

    public AbstractEnclosure(String name, float surface, int nbMaxCreature) {
        this.name = name;
        this.surface = surface;
        this.nbMaxCreature = nbMaxCreature;
        nbCurrentCreature = 0;
        creatureList = new ArrayList<>();
        type = "";
        life.start();
    }

    public AbstractEnclosure(String name, float surface, int nbMaxCreature, ArrayList<Creature> creatureList) throws Exception {
        if (creatureList.size() > nbMaxCreature) {
            throw new Exception("The provided creature list contains more creature than the maximum acceptable.");
        } else {
            this.name = name;
            this.surface = surface;
            this.nbMaxCreature = nbMaxCreature;
            this.creatureList = creatureList;
            nbCurrentCreature = creatureList.size();
        }
    }

    public AbstractEnclosure() {

    }

    public void addCreature(Creature creature) {

    }

    public void removeCreature(Creature creature) {
        if (creatureList.contains(creature)) {
            creatureList.remove(creature);
            --nbCurrentCreature;
            if(nbCurrentCreature<=0){
                setAnimalType(null);
            }
        }
        else{
            System.out.println("The creature you are trying to remove is not in this enclosure.");
        }

    }

    public ArrayList<Creature> getCreatureList() {
        return creatureList;
    }

    public int getNbCurrentCreature() {
        return nbCurrentCreature;
    }

    public void setNbCurrentCreature(int value) {
        nbCurrentCreature = value;
    }

    public int getNbMaxCreature() {
        return nbMaxCreature;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    protected void setEnclosureType(String type){
        this.type = type;
    }

    public Object getAnimalType() { return animalType;}

    public void setAnimalType(Object animalType) {this.animalType = animalType;}

    public void clean(int cleanlinessLevel) {
        if (cleanlinessLevel > 3) {
            System.out.println("Cleanliness level is too high please set it between 0 or 3.");
        } else if (cleanlinessLevel < 0) {
            System.out.println("Cleanliness level is too low please set it between 0 or 3.");
        } else {
            this.cleanlinessLevel = cleanlinessLevel;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }
    public void addFood(int quantity){
        foodMeter = foodMeter + quantity;
    }

    public int getFeeder() {
        return foodMeter;
    }

    public void setFeeder(int foodMeter) {
        this.foodMeter = foodMeter;
    }
    @Override
    public String toString() {
        return "AbstractEnclosure{" +
                "creatureList=" + creatureList +
                ", name='" + name + '\'' +
                ", surface=" + surface +
                ", nbMaxCreature=" + nbMaxCreature +
                ", nbCurrentCreature=" + nbCurrentCreature +
                ", cleanlinessLevel=" + cleanlinessLevel +
                ", type='" + type + '\'' +
                ", animalType=" + animalType +
                ", life=" + life +
                ", hp=" + hp +
                '}';
    }
}

