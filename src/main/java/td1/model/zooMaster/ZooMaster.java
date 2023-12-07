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
        while (true) {
            ZooMasterController.getInstance().execBehavior(myZoo);
        }
    }

    public void checkEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        System.out.println(abstractEnclosure);
    }

    public void cleanEnclosure(AbstractEnclosure<?> abstractEnclosure) {
        abstractEnclosure.clean();
    }

    public void feed(AbstractEnclosure<?> enclosure, int quantity) {
        enclosure.addFood(quantity);
    }

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
