package td1.model.creature;

import java.util.Random;
import td1.view.fileWritter.FileWriter;

public class Unicorn extends Viviparous implements Runner{
    public Unicorn(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(9);
    }

    @Override
    public String creatureRun() {
        return(getName() + " is running !\n");
    }

    @Override
    public void giveBirth(){
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just got engrossed.\n");
        Unicorn d1 = new Unicorn(getName() + "'s child", rd.nextBoolean(), 10, 10, -3);
        d1.setParentName(getName());
        d1.setCurrentEnclosure(getCurrentEnclosure());
        try {
            d1.getLife().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (getHealth() > 0) {
            if (!isPaused()){
                Random percentage = new Random();
                if(!isSleep()){
                    // The creature's hunger increases
                    if (percentage.nextInt(4) == 0) {
                        consumeFood(10);
                    }
                    // The creature hurts itself
                    if(percentage.nextInt(150) < 100-getHunger()){
                        checkForFood(getCurrentEnclosure());
                    }
                    // The creature checks for food in its enclosure
                    if (percentage.nextInt(101) < 8) {
                        setHealth(getHealth() - 5);
                    }
                    // The creature makes an action depending on what type of moves it can make
                    if (percentage.nextInt(101) < 25) {
                        FileWriter.writeInFile(creatureRun());
                    }
                    // The creature gives birth (only if female)
                    if (isSex() && percentage.nextInt(500) == 1){
                        giveBirth();
                    }
                }
                // The creature wakes up
                if (percentage.nextInt(101) < 10 && isSleep()) {
                    wake();
                }
                // The creature falls asleep
                else if(percentage.nextInt(101) < 10 && !isSleep()){
                    sleep();
                }

                // A little cooldown between actions to not spam the logs
                int cooldown = (3+percentage.nextInt(5))*1000;

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
