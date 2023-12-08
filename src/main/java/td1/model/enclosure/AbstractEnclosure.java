package td1.model.enclosure;

import td1.model.creature.Creature;
import td1.view.ColorInTerminal;

import java.util.ArrayList;

public abstract class AbstractEnclosure<Type> implements Runnable {
    protected Type type;
    protected ArrayList<Creature> creatureList = new ArrayList<>();
    private String name;
    private float surface;
    private int nbMaxCreature;
    private int nbCurrentCreature;
    private int cleanlinessLevel = 3;
    private String animalType = null;
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
            for (Creature creature : creatureList) {
                addCreature(creature);
            }
            nbCurrentCreature = creatureList.size();
        }
    }

    public AbstractEnclosure() {

    }

    /**
     * Adds a creature in the enclosure
     *
     * @param creature the creature added
     */
    public void addCreature(Creature creature) {
        if (getNbCurrentCreature() == getNbMaxCreature()) {
            System.out.println(ColorInTerminal.TEXT_RED + "This enclosure is already full" + ColorInTerminal.TEXT_RESET);
        } else if (creature.getInterface().contains(type.toString())) {
            if (getAnimalType() != null) {
                if (creature.getClass().getSimpleName() == getAnimalType()) {
                    creatureList.add(creature);
                    creature.setCurrentEnclosure(this);
                    setNbCurrentCreature(getNbCurrentCreature() + 1);
                } else {
                    System.out.println(ColorInTerminal.TEXT_RED + "You cannot add this type of creature in this enclosure." + ColorInTerminal.TEXT_RESET);
                }
            } else {
                setAnimalType(creature.getClass().getSimpleName());
                setEnclosureType(type);
                creatureList.add(creature);
                creature.setCurrentEnclosure(this);
                setNbCurrentCreature(getNbCurrentCreature() + 1);
            }
        } else if (creature.getInterface() == "none") {
            setAnimalType(creature.getClass().getSimpleName());
            setEnclosureType(type);
            creatureList.add(creature);
            creature.setCurrentEnclosure(this);
            setNbCurrentCreature(getNbCurrentCreature() + 1);
        } else {
            System.out.println(ColorInTerminal.TEXT_RED + "You cannot add this creature in this type of enclosure." + ColorInTerminal.TEXT_RESET);
        }
    }

    /**
     * Adds a creature in the enclosure
     *
     * @param creatures the list of creatures to add
     */
    public void addAllCreatures(ArrayList<Creature> creatures) {
        for (Creature creature : creatures) {
            addCreature(creature);
        }
    }

    /**
     * Removes a creature in the enclosure
     *
     * @param creature the creature removed
     */
    public void removeCreature(Creature creature) {
        if (creatureList.contains(creature)) {
            creatureList.remove(creature);
            --nbCurrentCreature;
            if (nbCurrentCreature <= 0) {
                setAnimalType(null);
            }
        } else {
            System.out.println("The creature you are trying to remove is not in this enclosure.");
        }
    }

    /**
     * Removes all creatures from the enclosure
     */
    public void removeAllCreatures() {
        creatureList.clear();
    }

    /**
     * Adds a creature in the enclosure
     *
     * @return the list of all creatures
     */
    public ArrayList<Creature> getCreatureList() {
        return creatureList;
    }

    /**
     * Set a list of creatures in the enclosure
     *
     * @param creatureList the list of creatures
     */
    public void setCreatureList(ArrayList<Creature> creatureList) {
        this.creatureList = creatureList;
    }

    /**
     * Set a list of creatures in the enclosure
     *
     * @return the type of the enclosure
     */
    public Type getEnclosureType() {
        return type;
    }

    /**
     * Set the type of enclosure
     *
     * @param type the list of creatures
     */
    protected void setEnclosureType(Type type) {
        this.type = type;
    }

    /**
     * Increases the cleanliness level of the enclosure
     */
    public void clean() {
        if (!creatureList.isEmpty()) {
            System.out.println(ColorInTerminal.TEXT_RED + "You cannot clean this " + this.getClass().getSimpleName() + " while creatures are still inside." + ColorInTerminal.TEXT_RESET);
        } else {
            cleanlinessLevel += 2;
            if (cleanlinessLevel > 3) {
                cleanlinessLevel = 3;
            }
            System.out.println(ColorInTerminal.TEXT_GREEN + "The enclosure has been successfully cleaned !" + ColorInTerminal.TEXT_RESET);
        }
    }

    /**
     * Returns the hp of the enclosure
     *
     * @return the hp of the enclosure
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the hp of the enclosure
     *
     * @param hp the hp of the enclosure
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Add a certain quantity of food to the feeder
     *
     * @param quantity the quantity of food
     */
    public void addFood(int quantity) {
        feeder = feeder + quantity;
        if (feeder > 500) {
            feeder = 500;
        }
    }

    /**
     * Returns the amount of food in the feeder
     *
     * @return the amount of food in the feeder
     */
    public int getFeeder() {
        return feeder;
    }

    /**
     * Sets the amount of food in the feeder
     *
     * @param feeder the amount of food in the feeder
     */
    public void setFeeder(int feeder) {
        if (feeder > 500) {
            feeder = 500;
        }
        this.feeder = feeder;
    }

    @Override
    public String toString() {
        String creatureListString = "\n";
        for (Creature creature : creatureList) {
            creatureListString += creature.shortToString() + "\n";
        }
        return ColorInTerminal.TEXT_PURPLE + "Enclosure name : " + name +
                "\nCreature list :" + creatureListString +
                "\nSurface : " + surface +
                "\nNumber of maximum creatures : " + nbMaxCreature +
                "\nNumber of current creatures : " + nbCurrentCreature +
                "\nCleanliness level : " + cleanlinessLevel +
                "\nEnclosure's type : " + type +
                "\nEnclosure's animals' specie : " + animalType + ColorInTerminal.TEXT_RESET;
    }

    /**
     * Returns the number of creatures in the enclosure
     *
     * @return the number of creatures in the enclosure
     */
    public int getNbCurrentCreature() {
        return nbCurrentCreature;
    }

    /**
     * Sets the number of creatures in the enclosure
     *
     * @param value the number of creatures in the enclosure
     */
    public void setNbCurrentCreature(int value) {
        nbCurrentCreature = value;
    }

    /**
     * Returns the max number of creatures in the enclosure
     *
     * @return the max number of creatures in the enclosure
     */
    public int getNbMaxCreature() {
        return nbMaxCreature;
    }

    /**
     * Returns the level of cleanliness of the enclosure
     *
     * @return the level of cleanliness of the enclosure
     */
    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    /**
     * Sets the cleanliness level of the enclosure
     *
     * @param cleanlinessLevel set the cleanliness level of the enclosure
     */
    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    /**
     * Returns the type of the animals in the enclosure
     *
     * @return the type of the animals in the enclosure
     */
    public Object getAnimalType() {
        return animalType;
    }

    /**
     * Set the type of the animals
     *
     * @param animalType the animal type
     */
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    /**
     * Returns the type of the enclosure
     *
     * @return the type of the enclosure
     */
    public Type getType() {
        return type;
    }
}

