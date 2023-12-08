package td1.model.zooMaster;

import td1.controller.ZooMasterController;
import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.enclosure.Enclosure;
import td1.model.fantasticZoo.FantasticZoo;
import td1.view.ShowInTerminal;
import td1.view.ZooMasterView;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMaster implements Runnable {
    private String name;
    private boolean sex;
    private int age;
    private FantasticZoo myZoo;

    private boolean playing = true;

    public ZooMaster(String name, boolean sex, int age, FantasticZoo myZoo) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.myZoo = myZoo;
    }
    public ZooMaster(){};

    /**
     * The run needed to start a thread.
     * Starts the zoomaster commands
     */
    public void run() {
        while (playing) {
            ZooMasterController.getInstance().execBehavior(myZoo);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMyZoo(FantasticZoo myZoo) {
        this.myZoo = myZoo;
    }

    /**
     * Prints out the enclosure's stats
     *
     * @param abstractEnclosure the enclosure to check
     */
    public void checkEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        System.out.println(abstractEnclosure);
    }

    /**
     * Cleans an enclosure
     *
     * @param abstractEnclosure the enclosure to clean
     */
    public void cleanEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        abstractEnclosure.clean();
    }

    /**
     * Add foods to the feeder of an enclosure
     *
     * @param enclosure the enclosure to check
     * @param quantity the quantity of food
     */
    public void feed(AbstractEnclosure<?> enclosure, int quantity) {
        enclosure.addFood(quantity);
    }

    /**
     * Transfers a creature to another enclosure
     *
     * @param creature the creature to transfer
     * @param abstractEnclosureFrom the enclosure where the creature is from
     * @param abstractEnclosureTarget the enclosure where the creature is going to go
     */
    public void transferOneCreature(Creature creature, AbstractEnclosure<?> abstractEnclosureFrom, AbstractEnclosure<?> abstractEnclosureTarget) {
        Creature creatureToTransfer = creature;
        int amountOfCreaturesBeforeAdd = abstractEnclosureTarget.getNbCurrentCreature();
        abstractEnclosureTarget.addCreature(creature);
        if(abstractEnclosureTarget.getNbCurrentCreature()!= amountOfCreaturesBeforeAdd+1){
            ZooMasterView.getInstance().transferFailed();
        }else {
            abstractEnclosureFrom.removeCreature(creature);
            ZooMasterView.getInstance().transferSucceeded();
        }
    }
    public void stopTheGame(){
        playing = false;
    }
    /**
     * Transfers all the creatures from an enclosure to another
     *
     * @param abstractEnclosureFrom the enclosure where the creatures are from
     * @param abstractEnclosureTarget the enclosure where the creatures are going to go
     */
    public void transferAllCreatures(AbstractEnclosure<?> abstractEnclosureFrom, AbstractEnclosure<?> abstractEnclosureTarget){
        int amountOfCreaturesBeforeAdd = abstractEnclosureTarget.getNbCurrentCreature();
        int creatureToTransfer = abstractEnclosureFrom.getNbCurrentCreature();
        ArrayList<Creature> creaturesToTransfer = new ArrayList<>(abstractEnclosureFrom.getCreatureList());
        abstractEnclosureTarget.addAllCreatures(creaturesToTransfer);
        if (abstractEnclosureTarget.getNbCurrentCreature() == amountOfCreaturesBeforeAdd + creatureToTransfer){
            ZooMasterView.getInstance().transferSucceeded();
            abstractEnclosureFrom.removeAllCreatures();
        }else {
            ZooMasterView.getInstance().transferFailed();
        }
    }
}
