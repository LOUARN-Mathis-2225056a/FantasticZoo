package td1.model.creature;

import td1.model.enclosure.AbstractEnclosure;
import td1.view.fileWritter.FileWriter;

import java.util.Arrays;

public abstract class Creature implements Runnable {
    private boolean paused = false;
    private String parentName;
    private Thread life;
    private String name;
    //true = female
    //false = male
    final private boolean sex;
    private float weight;
    private float height;
    private int hunger = 100;
    private boolean sleep = false;
    private int health = 100;
    private int age = 0;
    private int eatingValue;
    private AbstractEnclosure<?> currentEnclosure;

    /* CONSTRUCTOR */
    public Creature(String name, boolean sex, float weight, float height, int age) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        life = new Thread(this);
        life.start();
    }
    public Creature(String name, boolean sex, float weight, float height, int age, AbstractEnclosure<?> currentEnclosure) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        life = new Thread(this);
        life.start();
        this.currentEnclosure = currentEnclosure;
    }

    /* GETTER */
    public String getName() {
        return name;
    }

    /* SETTER */
    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isPaused() {
        return paused;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public AbstractEnclosure<?> getCurrentEnclosure() {
        return currentEnclosure;
    }

    public void setCurrentEnclosure(AbstractEnclosure<?> currentEnclosure) {
        this.currentEnclosure = currentEnclosure;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public Thread getLife() {
        return life;
    }

    public void setLife(Thread life) {
        this.life = life;
    }

    public void setEatingValue(int eatingValue) {
        this.eatingValue = eatingValue;
    }

    public int getEatingValue() {return eatingValue;}

    /**
     * Make the creature eat, therefore decreases its hunger value. Creature can't eat while sleeping
     */
    public void eat() {
        if (hunger <= 100-eatingValue && !sleep) {
            hunger += eatingValue;
            FileWriter.writeInFile(name + "'s hunger is at " + hunger, "logs");
        } else if (!sleep) {
            FileWriter.writeInFile(name + " is not hungry.","logs");
        }
        else {
            FileWriter.writeInFile(name + " is sleeping : it can not eat right now !", "logs");
        }
    }

    /**
     * Simulates the hunger. Increases hunger value
     *
     * @param value how much the creature's hunger increases
     */
    public void consumeFood(int value) {
        if (value > hunger) {
            hunger = 0;
            health -= 1; /* take damage */
            FileWriter.writeInFile(name + " is starving.\n","logs");
        } else {
            hunger -= value;
            FileWriter.writeInFile(name + " gets a little hungrier.\n","logs");
        }
    }

    /**
     * Makes the creature get its food from the enclosure
     *
     * @param enclosure in what enclosure the creature checks for food
     */
    public void checkForFood(AbstractEnclosure<?> enclosure){
        if(enclosure.getFeeder() > eatingValue){
            eat();
            enclosure.setFeeder(enclosure.getFeeder()-eatingValue);
        }
    }

    /**
     * Makes the creature emit a sound
     */
    public void emitSound() {
        FileWriter.writeInFile(name + " emits a sound.");
    }

    /**
     * Increases the creature's health points
     */
    public void heal() {
        String str = null;
        if (health <= 90) {
            health += 10;
            FileWriter.writeInFile(name + "'s health is now at  " + health + "\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already healthy.\n","logs");
        }
    }

    /**
     * Wakes up the creature
     */
    public void wake() {
        if (sleep) {
            sleep = false;
            FileWriter.writeInFile(name + " wakes up.\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already awake.\n","logs");
        }
    }

    /**
     * Makes the creature fall asleep
     */
    public void sleep() {
        if (!sleep) {
            sleep = true;
            FileWriter.writeInFile(name + " falls asleep.\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already asleep.\n","logs");
        }
    }

    /**
     * Returns the creature's interface.
     * Is used to sort creatures by their interface and allow them in an enclosure
     *
     * @return the interface of the creature's class
     */
    public String getInterface() {
        String implementedInterface = Arrays.toString(getClass().getInterfaces());
        if (implementedInterface.contains("Runner") ||
                implementedInterface.contains("Flyer") ||
                implementedInterface.contains("Swimmer")) {
            return implementedInterface;
        }
        return "none";
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    /**
     * Returns an easier to read toString
     *
     * @return an easier to read toString
     */
    public String shortToString() {
        String gender = "";
        if(sex){
            gender = "female";
        } else {gender = "male";}
        return gender + " " + name + " aged of " + age + " years old." + " has " + health + " life points.";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{\n" +
                "    name : " + name + "\n" +
                "    sex : " + sex + "\n" +
                "    weight : " + weight + "\n" +
                "    height : " + height + "\n" +
                "    hunger : " + hunger + "%" + "\n" +
                "    sleep : " + sleep + "\n" +
                "    health : " + health + "%" + "\n" +
                "    age : " + age + "\n" +
                "}";
    }
}