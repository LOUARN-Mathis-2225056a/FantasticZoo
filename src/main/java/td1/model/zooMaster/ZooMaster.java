package td1.model.zooMaster;

import td1.controller.ZooMasterController;
import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.enclosure.Enclosure;
import td1.model.fantasticZoo.FantasticZoo;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMaster implements Runnable {
    private final String name;
    private final boolean sex;
    private final int age;
    private final FantasticZoo myZoo;

    public ZooMaster(String name, boolean sex, int age, FantasticZoo myZoo) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.myZoo = myZoo;
    }

    public void run() {
        ZooMasterController.getInstance().execBehavior(myZoo);
    }

    public void checkEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        System.out.println(abstractEnclosure);
    }

    public void cleanEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        abstractEnclosure.clean();
    }

    public void feed(Enclosure enclosure, int quantity) {
        enclosure.addFood(quantity);
    }

    public void transfer(Creature creature, AbstractEnclosure<?> abstractEnclosureFrom, AbstractEnclosure<?> abstractEnclosureTarget) {
        abstractEnclosureFrom.removeCreature(creature);
        abstractEnclosureTarget.addCreature(creature);
    }
}
