package model.creature;

public class Megalodon extends Oviparous implements Swimmer{
    public Megalodon(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !");
    }
}
