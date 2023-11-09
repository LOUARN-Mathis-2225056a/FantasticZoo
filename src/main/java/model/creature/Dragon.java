package model.creature;

public class Dragon extends Oviparous implements Runner,Reborner,Flyer,Swimmer{
    public Dragon(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }
    @Override
    public String creatureFly() {
        return(getName() + " is flying !");
    }

    @Override
    public void creatureReborn() {

    }

    @Override
    public String creatureRun() {
        return(getName() + " is running !");
    }

    @Override
    public String creatureSwim() {
        return(getName() + " is swimming !");
    }

    @Override
    public void run() {

    }
}
