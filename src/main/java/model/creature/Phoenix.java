package model.creature;

public class Phoenix extends Oviparous implements Flyer,Reborner{
    public Phoenix(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        super(name, sexe, weight, height, hunger, sleep, health, age);
    }

    @Override
    public void creatureFly() {
        System.out.println(getName() + " is flying !");
    }

    @Override
    public void creatureReborn() {

    }
}
