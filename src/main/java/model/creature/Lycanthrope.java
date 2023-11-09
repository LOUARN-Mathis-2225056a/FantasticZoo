package model.creature;

public class Lycanthrope extends Viviparous implements Runner{

    public Lycanthrope(String name, boolean sexe, float weight, float height,int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public String creatureRun() {
        return(getName() + " is running !");
    }
}
