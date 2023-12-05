package td1.creature;

import td1.fileWritter.FileWriter;


import java.util.Random;

public class Nymph extends Viviparous implements Reborner{
    public Nymph(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(2);
    }

    @Override
    public void creatureReborn() {
        FileWriter.writeInFile(getName() + " reborned !\n");
        setHealth(100);
        setAge(0);
        setLife(new Thread(this));
        getLife().start();
    }

    @Override
    public void giveBirth(){
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just got engrossed.\n");
        Nymph d1 = new Nymph(getName() + "'s child", rd.nextBoolean(), 10, 10, -3);
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
            if (isSex() && percentage.nextInt(500) == 1){
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
        FileWriter.writeInFile(getName() + " is coming to fife again.\n");
        creatureReborn();
    }
}
