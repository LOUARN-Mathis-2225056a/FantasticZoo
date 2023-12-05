package td1.creature;

import java.util.Random;
import td1.fileWritter.FileWriter;

public class Megalodon extends Oviparous implements Swimmer{
    public Megalodon(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
        setEatingValue(20);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !\n");
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
            if(percentage.nextInt(150) < 100-getHunger()){
                checkForFood(getCurrentEnclosure());
            }
            if (percentage.nextInt(101) < 25) {
                FileWriter.writeInFile(creatureSwim());
            }

            int cooldown = (3+percentage.nextInt(5))*1000;

            try {
                Thread.sleep(cooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        FileWriter.writeInFile(getName() + " died.\n");
    }
}
