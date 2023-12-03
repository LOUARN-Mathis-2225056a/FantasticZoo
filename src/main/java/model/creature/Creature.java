package model.creature;

import model.enclosure.Enclosure;
import model.fileWritter.FileWriter;

import java.util.Arrays;

public abstract class Creature implements Runnable {

    private Thread life;
    private String name;
    private boolean sexe;
    private float weight;
    private float height;
    private int hunger = 100;
    private boolean sleep = false;
    private int health = 100;
    private int age = 0;
    private int eatingValue;
    private Enclosure currentEnclosure;

    /* CONSTRUCTOR */
    public Creature(String name, boolean sexe, float weight, float height, int age) {
        this.name = name;
        this.sexe = sexe;
        this.weight = weight;
        this.height = height;
        this.age = age;
        life = new Thread(this);
        life.start();
    }
    public Creature(String name, boolean sexe, float weight, float height, int age, Enclosure currentEnclosure) {
        this.name = name;
        this.sexe = sexe;
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

    public Enclosure getCurrentEnclosure() {
        return currentEnclosure;
    }

    public void setCurrentEnclosure(Enclosure currentEnclosure) {
        this.currentEnclosure = currentEnclosure;
    }

    /* METHOD */
    public void eat() {
        if (hunger <= eatingValue) {
            hunger += eatingValue;
            FileWriter.writeInFile(name + "'s hunger is at " + hunger, "logs");
        } else {
            FileWriter.writeInFile(name + " is not hungry.","logs");
        }
    }
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
    public void checkForFood(Enclosure enclosure){
        if(enclosure.getFeeder() > eatingValue){
            eat();
            enclosure.setFeeder(enclosure.getFeeder()-eatingValue);
        }
    }
    public void emitSound() {
        System.out.println("???");
    }

    public void heal() {
        String str = null;
        if (health <= 90) {
            health += 10;
            FileWriter.writeInFile(name + "'s health is now at  " + health + "\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already healthy.\n","logs");
        }
    }

    public void wake() {
        if (sleep) {
            sleep = false;
            FileWriter.writeInFile(name + " wake up.\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already awake.\n","logs");
        }
    }

    public void sleep() {
        if (!sleep) {
            sleep = true;
            FileWriter.writeInFile(name + " falls asleep.\n","logs");
        } else {
            FileWriter.writeInFile(name + " is already asleep.\n","logs");
        }
    }

    public String getInterface() {
        String implementedInterface = Arrays.toString(getClass().getInterfaces());
        if (implementedInterface.contains("Runner") ||
                implementedInterface.contains("Flyer") ||
                implementedInterface.contains("Swimmer")) {
            return implementedInterface;
        }
        return "none";
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


    public String shortToString() {
        return name + " aged of " + age + "years old.";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{\n" +
                "    name : " + name + "\n" +
                "    sexe : " + sexe + "\n" +
                "    weight : " + weight + "\n" +
                "    height : " + height + "\n" +
                "    hunger : " + hunger + "%" + "\n" +
                "    sleep : " + sleep + "\n" +
                "    health : " + health + "%" + "\n" +
                "    age : " + age + "\n" +
                "}";
    }
}