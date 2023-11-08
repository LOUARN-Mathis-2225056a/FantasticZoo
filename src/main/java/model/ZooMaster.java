package model;

public class ZooMaster {
    private String name;
    private boolean sexe;
    private int age;

    public void checkEnclosure(Enclosure enclosure){
        System.out.println(enclosure);
    }

    public void cleanEnclosure(Enclosure enclosure){
        enclosure.clean();
    }

    public void feed(Creature creature){
        creature.eat();
    }

    public void transfer(Creature creature, Enclosure enclosureFrom, Enclosure enclosureTarget){
        enclosureFrom.removeCreature(creature);
        enclosureTarget.addCreature(creature);
    }
}
