package td1.creature;

import java.util.Random;
import td1.fileWritter.FileWriter;

public class Kraken extends Oviparous implements Swimmer{
    public Kraken(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(25);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !\n");
    }

    @Override
    public void giveBirth(){
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just laid an egg.");
        Kraken p1 = new Kraken(getName() + "'s egg", rd.nextBoolean(), 10, 10, -10);
        p1.setParentName(getName());
        p1.setCurrentEnclosure(getCurrentEnclosure());
        try {
            p1.getLife().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (getHealth() > 0) {
            if(getAge() >= 0) {
                Random percentage = new Random();
                if (percentage.nextInt(4) == 0) {
                    consumeFood(10);
                }
                if (percentage.nextInt(101) < 8) {
                    setHealth(getHealth() - 5);
                }
                if (percentage.nextInt(150) < 100 - getHunger()) {
                    checkForFood(getCurrentEnclosure());
                }
                if (percentage.nextInt(101) < 10 && isSleep()) {
                    wake();
                } else if (percentage.nextInt(101) < 10 && !isSleep()) {
                    sleep();
                }

                if (percentage.nextInt(101) < 25) {
                    FileWriter.writeInFile(creatureSwim());
                }

                int cooldown = (3 + percentage.nextInt(5)) * 1000;

                try {
                    Thread.sleep(cooldown);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        FileWriter.writeInFile(getName() + " died.\n");
    }
}
