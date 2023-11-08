package model;

import java.util.ArrayList;

public class Enclos {
    private String nom;
    private float superficie;
    private int nbMaxCreature;
    private int nbCreatureActuel;
    private String proprete = "bon";
    private ArrayList<Creature> listeCreature = new ArrayList<>();

    public void ajouterCreature(Creature creature){
        listeCreature.add(creature);
    }

    public void retirerCreature(Creature creature){
        listeCreature.remove(creature);
    }

    public void nettoyer(){
        if (proprete == "bon"){

        }
    }
}

