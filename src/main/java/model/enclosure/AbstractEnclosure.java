package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public abstract class AbstractEnclosure<Type> implements Runnable{
    protected Type type;
    protected ArrayList<Creature> creatureList = new ArrayList<>();
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private int cleanlinessLevel = 3;
    private Object animalType = null;
    private Thread life = new Thread(this);
    private int hp = 100;
    private int feeder;

    public AbstractEnclosure(String name, float surface, int nbMaxCreature) {
        this.name = name;
        this.surface = surface;
        this.nbMaxCreature = nbMaxCreature;
        nbCurrentCreature = 0;
        creatureList = new ArrayList<>();
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

    public void addCreature(Creature creature){
        if(getNbCurrentCreature()==getNbMaxCreature()){
            System.out.println("This enclosure is already full");
        }
        else if (creature.getInterface().contains(type.toString())){
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
        feeder = feeder + quantity;
        if (feeder > 500){
            feeder = 500;
        }
    }

    public int getFeeder() {
        return feeder;
    }

    public void setFeeder(int feeder) {
        if (feeder > 500){
            feeder = 500;
        }
        this.feeder = feeder;
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

