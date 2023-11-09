package model.enclosure;

import model.creature.Creature;

import java.util.ArrayList;

public class Aquarium extends Enclosure {
    private float depht;
    private int salinity;

    public Aquarium(String name, float surface, int nbMaxCreature, ArrayList<Creature> listeCreature, float depht, int salinity) {
        super(name, surface, nbMaxCreature, listeCreature);
        this.depht = depht;
        this.salinity = salinity;
    }

    @Override
    public void clean() {
        /*code*/
    }
}
