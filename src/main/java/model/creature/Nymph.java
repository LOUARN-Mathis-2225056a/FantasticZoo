package model.creature;

import model.enclosure.Enclosure;

import java.util.Random;

public class Nymph extends Viviparous{
    public Nymph(String name, boolean sexe, float weight, float height, int age) {
        super(name, sexe, weight, height, age);
    }

    @Override
    public void run() {
        Random percentage = new Random();
        if (percentage.nextInt(2) == 0){
            consumeFood(10);
        }
        if (percentage.nextInt(101) < 8){
            setHealth(getHealth()-5);
        }
    }
}
