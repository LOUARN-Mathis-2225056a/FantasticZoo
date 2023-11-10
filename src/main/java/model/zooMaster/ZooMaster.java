package model.zooMaster;

import model.creature.Creature;
import model.enclosure.AbstractEnclosure;

public class ZooMaster {
    private String name;
    private boolean sexe;
    private int age;

    public void checkEnclosure(AbstractEnclosure abstractEnclosure){
        System.out.println(abstractEnclosure);
    }

    public void cleanEnclosure(AbstractEnclosure abstractEnclosure, int cleanlinessLevel){
        abstractEnclosure.clean(cleanlinessLevel);
    }

    public void feed(Creature creature){
        creature.eat();
    }

    public void transfer(Creature creature, AbstractEnclosure abstractEnclosureFrom, AbstractEnclosure abstractEnclosureTarget) throws Exception {
        abstractEnclosureFrom.removeCreature(creature);
        abstractEnclosureTarget.addCreature(creature);
    }
}
