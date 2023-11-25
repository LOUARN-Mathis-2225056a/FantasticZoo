package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public abstract class AbstractEnclosure {
    protected ArrayList<Creature> creatureList = new ArrayList<>();
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private int cleanlinessLevel = 3;
    private String type = "";
    private Object animalType = null;

    public AbstractEnclosure(String name, float surface, int nbMaxCreature) {
        this.name = name;
        this.surface = surface;
        this.nbMaxCreature = nbMaxCreature;
        nbCurrentCreature = 0;
        creatureList = new ArrayList<>();
        type = "";
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
}

