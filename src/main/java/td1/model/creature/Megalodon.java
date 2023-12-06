package td1.model.creature;

import java.util.Random;
import td1.view.fileWritter.FileWriter;

public class Megalodon extends Oviparous implements Swimmer{
    public Megalodon(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(20);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !\n");
    }

    @Override
    public void giveBirth(){
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just laid an egg.");
        Megalodon p1 = new Megalodon(getName() + "'s egg", rd.nextBoolean(), 10, 10, -10);
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
            if(getAge() >= 0 && !isPaused()) {
                Random percentage = new Random();
                if (percentage.nextInt(4) == 0) {
                    consumeFood(10);
                }
                if (percentage.nextInt(101) < 8) {
                    setHealth(getHealth() - 5);
                }
                if (percentage.nextInt(101) < 10 && isSleep()) {
                    wake();
                } else if (percentage.nextInt(101) < 10 && !isSleep()) {
                    sleep();
                }
                if (percentage.nextInt(150) < 100 - getHunger()) {
                    checkForFood(getCurrentEnclosure());
                }
                if (percentage.nextInt(101) < 25) {
                    FileWriter.writeInFile(creatureSwim());
                }
                if (isSex() && percentage.nextInt(500) == 1){
                    giveBirth();
                }

                int cooldown = (3 + percentage.nextInt(5)) * 1000;

                try {
                    Thread.sleep(cooldown);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        FileWriter.writeInFile(getName() + " died.\n");
    }
}
