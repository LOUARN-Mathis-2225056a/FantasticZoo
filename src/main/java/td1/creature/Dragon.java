package td1.creature;
import td1.fileWritter.FileWriter;

import java.util.Random;

public class Dragon extends Oviparous implements Runner,Reborner,Flyer,Swimmer{
    public Dragon(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
        setEatingValue(25);
    }
    @Override
    public String creatureFly() {
        return(getName() + " is flying !\n");
    }

    @Override
    public void creatureReborn() {
        FileWriter.writeInFile(getName() + " reborned !");
        setHealth(100);
        setAge(0);
    }

    @Override
    public String creatureRun() {
        return(getName() + " is running !\n");
    }

    @Override
    public String creatureSwim() {
        return(getName() + " is swimming !\n");
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

            if (percentage.nextInt(101) < 25) {
                FileWriter.writeInFile(creatureSwim());
            }
            else if (percentage.nextInt(101) < 25) {
                FileWriter.writeInFile(creatureRun());
            }
            else if (percentage.nextInt(101) < 25) {
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
    }
}
