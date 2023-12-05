package td1.creature;

import java.util.Random;
import td1.fileWritter.FileWriter;

public class Mermaid extends Viviparous implements Swimmer{
    public Mermaid(String name, boolean sex, float weight, float height, int age){
        super(name,sex,weight,height,age);
        setEatingValue(6);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !\n");
    }

    @Override
    public void giveBirth(){
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just got engrossed.\n");
        Mermaid d1 = new Mermaid(getName() + "'s child", rd.nextBoolean(), 10, 10, -3);
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
            if (percentage.nextInt(500) == 1){
                giveBirth();
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
