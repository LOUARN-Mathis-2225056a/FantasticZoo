package model.creature;
import java.util.Random;

public abstract class Oviparous extends Creature{

    public Oviparous(String name, boolean sex, float weight, float height, int age) {
        super(name, sex, weight, height, age);
        if(age < 0){
            try {
                getLife().wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void giveBirth(){
    }
}
