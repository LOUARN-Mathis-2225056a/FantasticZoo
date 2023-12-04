package model.creature;

import java.util.Random;

import model.enclosure.AbstractEnclosure;
import model.enclosure.Enclosure;
import model.fileWritter.FileWriter;

public class Phoenix extends Oviparous implements Flyer,Reborner{
    public Phoenix(String name, boolean sexe, float weight, float height, int age, AbstractEnclosure currentEnclosure) {
        super(name, sexe, weight, height, age, currentEnclosure);
        setEatingValue(11);
    }

    @Override
    public String creatureFly() {
        return (getName() + " is flying !\n");
    }

    @Override
    public void creatureReborn() {
        FileWriter.writeInFile(getName() + " reborned !");
        setHealth(100);
        setAge(0);
    }

    @Override
    public void run() {
        while (getHealth() > 0) {
            Random percentage = new Random();
            if (percentage.nextInt(4) == 0) {
                consumeFood(10);
            }
            if (percentage.nextInt(101) < 8) {
                setHealth(getHealth() - 5);
            }
            if(percentage.nextInt(150) < 100-getHunger()){
                checkForFood(getCurrentEnclosure());
            }
            if (percentage.nextInt(101) < 10 && isSleep()) {
                wake();
            }
            else if(percentage.nextInt(101) < 10 && !isSleep()){
                sleep();
            }

            if (percentage.nextInt(101) < 25) {
                FileWriter.writeInFile(creatureFly());
            }

            int cooldown = (3+percentage.nextInt(5))*1000;

            try {
                Thread.sleep(cooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        FileWriter.writeInFile(getName() + " died.\n");
        creatureReborn();
    }
}
