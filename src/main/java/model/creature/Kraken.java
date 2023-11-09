package model.creature;

public class Kraken extends Oviparous implements Swimmer{
    public Kraken(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !");
    }

    @Override
    public void run() {

    }
}
