package model.creature;

public class Dragon extends Oviparous implements Runner,Reborner,Flyer,Swimmer{
    public Dragon(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        super(name, sexe, weight, height, hunger, sleep, health, age);
    }

    @Override
    public void creatureFly() {
        System.out.println(getName() + " is flying !");
    }

    @Override
    public void creatureReborn() {

    }

    @Override
    public void creatureRun() {
        System.out.println(getName() + " is running !");
    }

    @Override
    public void creatureSwim() {
        System.out.println(getName() + " is swimming !");
    }
}
