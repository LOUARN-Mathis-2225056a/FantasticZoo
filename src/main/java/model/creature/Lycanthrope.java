package model.creature;

public class Lycanthrope extends Viviparous implements Runner{

    public Lycanthrope(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        super(name, sexe, weight, height, hunger, sleep, health, age);
    }

    @Override
    public void creatureRun() {
        System.out.println(getName() + " is running !");
    }
}
