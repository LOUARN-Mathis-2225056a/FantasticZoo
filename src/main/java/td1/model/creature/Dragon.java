package td1.model.creature;
import td1.model.fileWritter.FileWriter;

import java.util.Random;

public class Dragon extends Oviparous implements Runner,Reborner,Flyer,Swimmer{
    public Dragon(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(25);
    }

    /**
     * Return a prompt of the creature flying
     *
     * @return the prompt of the creature flying
     */
    @Override
    public String creatureFly() {
        return(getName() + " is flying !\n");
    }

    /**
     * Reborn the creature
     */
    @Override
    public void creatureReborn() {
        FileWriter.writeInFile(getName() + " reborned !");
        setHealth(100);
        setAge(0);
        setLife(new Thread(this));
        getLife().start();
    }

    /**
     * Creates a new egg (a creature with a negative age)
     *
     * @throws RuntimeException
     */
    @Override
    public void giveBirth() {
        Random rd = new Random();
        FileWriter.writeInFile(getName() + " just laid an egg.");
        Dragon d1 = new Dragon(getName() + "'s egg", rd.nextBoolean(), 10, 10, -10);
        d1.setParentName(getName());
        d1.setCurrentEnclosure(getCurrentEnclosure());
        try {
            d1.getLife().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a prompt of the creature running
     *
     * @return the prompt of the creature running
     */
    @Override
    public String creatureRun() {
        return(getName() + " is running !\n");
    }

    /**
     * Returns a prompt of the creature swimming
     *
     * @return the prompt of the creature swimming
     */
    @Override
    public String creatureSwim() {
        return(getName() + " is swimming !\n");
    }

    /**
     * Defines the life of the creature and its behavior in the game.
     * Is used by threads
     *
     * @throws RuntimeException
     */
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

                if (percentage.nextInt(101) < 25) {
                    FileWriter.writeInFile(creatureSwim());
                } else if (percentage.nextInt(101) < 25) {
                    FileWriter.writeInFile(creatureRun());
                } else if (percentage.nextInt(101) < 25) {
                    FileWriter.writeInFile(creatureFly());
                }
                if (isSex() && percentage.nextInt(500) == 1){
                    giveBirth();
                }

                int cooldown = (3 + percentage.nextInt(5)) * 1000;

                try {
                    Thread.sleep(cooldown);
                } catch (InterruptedException e) {
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
        creatureReborn();
    }
}
