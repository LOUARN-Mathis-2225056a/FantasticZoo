package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aviary extends Enclosure {
    private float height;

    public Aviary(String name, float surface, int nbMaxCreature, ArrayList<Creature> listeCreature, float height) {
        super(name, surface, nbMaxCreature, listeCreature);
        this.height = height;
    }

    @Override
    public void clean() {
        /*code*/
    }
}
