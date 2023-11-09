package model.creature;

public abstract class Oviparous extends Creature{

    public Oviparous(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    public void giveBirth(){
    }
}
