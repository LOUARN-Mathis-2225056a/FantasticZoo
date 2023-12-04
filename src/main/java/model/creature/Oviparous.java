package model.creature;

import model.enclosure.AbstractEnclosure;
import model.enclosure.Enclosure;

public abstract class Oviparous extends Creature{


    public Oviparous(String name, boolean sexe, float weight, float height, int age, AbstractEnclosure currentEnclosure) {
        super(name, sexe, weight, height, age, currentEnclosure);
    }

    public void giveBirth(){
    }
}
