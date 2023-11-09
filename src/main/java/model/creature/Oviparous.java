package model.creature;

public class Oviparous extends Creature{

    public Oviparous(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        super(name, sexe, weight, height, hunger, sleep, health, age);
    }

    public void giveBirth(){
    }
}
