package model.creature;

import model.enclosure.Enclosure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Nymph extends Viviparous implements Reborner{
    public Nymph(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public void creatureReborn() {
        System.out.println(getName() + " reborned !");
        setHealth(100);
        setAge(0);
        setLife(new Thread(this));
        getLife().start();
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

            if (percentage.nextInt(101) < 10 && isSleep()) {
                wake();
            }
            else if(percentage.nextInt(101) < 10 && !isSleep()){
                sleep();
            }

            int cooldown = (3+percentage.nextInt(5))*1000;

            try {
                Thread.sleep(cooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName() + " died.\n");
        System.out.println(getName() + " is coming to fife again.\n");
        creatureReborn();
    }
}
