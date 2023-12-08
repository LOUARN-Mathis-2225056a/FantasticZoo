package td1.model.creature;

import td1.view.fileWritter.FileWriter;

import java.util.Random;

public class Phoenix extends Oviparous implements Flyer, Reborner {
    public Phoenix(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        setEatingValue(11);
    }

    /**
     * Return a prompt of the creature flying
     *
     * @return the prompt of the creature flying
     */
    @Override
    public String creatureFly() {
        return (getName() + " is flying !\n");
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
        FileWriter.writeInFile(getName() + " just laid an egg.\n");
        Phoenix p1 = new Phoenix(getName() + "'s egg", rd.nextBoolean(), 10, 10, -10);
        p1.setParentName(getName());
        p1.setCurrentEnclosure(getCurrentEnclosure());
        try {
            p1.getLife().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
            if (getAge() >= 0 && !isPaused()) {
                Random percentage = new Random();
                if (!isSleep()) {
                    if (percentage.nextInt(4) == 0) {
                        consumeFood(10);
                    }

                    if (percentage.nextInt(101) < 8) {
                        setHealth(getHealth() - 5);
                    }

                    if (percentage.nextInt(150) < 100 - getHunger()) {
                        checkForFood(getCurrentEnclosure());
                    }

                    if (isSex() && percentage.nextInt(500) == 1) {
                        giveBirth();
                    }

                    if (percentage.nextInt(101) < 25) {
                        FileWriter.writeInFile(creatureFly());
                    }
                }
                // The creature wakes up
                if (percentage.nextInt(101) < 10 && isSleep()) {
                    wake();
                }
                // The creature falls asleep
                else if (percentage.nextInt(101) < 10 && !isSleep()) {
                    sleep();
                }

                // A little cooldown between actions to not spam the logs
                int cooldown = (3 + percentage.nextInt(5)) * 1000;

                try {
                    Thread.sleep(cooldown);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
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
