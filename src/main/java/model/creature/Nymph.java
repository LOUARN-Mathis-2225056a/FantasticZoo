package model.creature;

import model.enclosure.Enclosure;

import java.util.Random;

public class Nymph extends Viviparous {
    public Nymph(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public void run() {
        while(this.getHealth() > 0) {
            Random percentage = new Random();
            if(percentage.nextInt(1000000000) == 4){

            }
        }
    }
}
