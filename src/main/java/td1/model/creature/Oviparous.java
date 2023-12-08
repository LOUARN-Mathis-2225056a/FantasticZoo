package td1.model.creature;

public abstract class Oviparous extends Creature {

    public Oviparous(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
    }

    public void giveBirth() {
    }
}
