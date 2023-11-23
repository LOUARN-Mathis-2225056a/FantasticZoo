package model.creature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    private void writeInFile(String str){

        String fileName = "logs";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    /* METHOD */
    public void eat() {
        String str = null;
        if (hunger <= 90) {
            hunger += 10;
            writeInFile(name + "'s hunger is at " + hunger);
        } else {
            writeInFile(name + " is not hungry.");
        }
    }

    public void consumeFood(int value) {
        if (value > hunger) {
            hunger = 0;
            health -= 1; /* take damage */
            writeInFile(name + " is starving.\n");
        } else {
            hunger -= value;
            writeInFile(name + " gets a little hungrier.\n");
        }
    }

    public void emitSound() {
        System.out.println("???");
    }

    public void heal() {
        String str = null;
        if (health <= 90) {
            health += 10;
            writeInFile(name + "'s health is now at  " + health + "\n");
        } else {
            writeInFile(name + " is already healthy.\n");
        }
    }

    public void wake() {
        if (sleep) {
            sleep = false;
            writeInFile(name + " wake up.\n");
        } else {
            writeInFile(name + " is already awake.\n");
        }
    }

    public void sleep() {
        if (!sleep) {
            sleep = true;
            writeInFile(name + " falls asleep.\n");
        } else {
            writeInFile(name + " is already asleep.\n");
        }
    }

    public String getInterface() {
        return Arrays.toString(getClass().getInterfaces());
    }

    public String shortToString() {
        return "";
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

