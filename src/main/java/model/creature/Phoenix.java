package model.creature;

public class Phoenix extends Oviparous implements Flyer,Reborner{
    public Phoenix(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public String creatureFly() {
        return (getName() + " is flying !");
    }

    @Override
    public void creatureReborn() {

    }

    @Override
    public void run() {

    }
}
