package model.creature;

import java.util.Random;

public class Unicorn extends Viviparous implements Runner{
    public Unicorn(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public String creatureRun() {
        return(getName() + " is running !\n");
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
                System.out.println(creatureRun());
            }

            int cooldown = (3+percentage.nextInt(5))*1000;

            try {
                Thread.sleep(cooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(getName() + " died.\n");
    }
}
