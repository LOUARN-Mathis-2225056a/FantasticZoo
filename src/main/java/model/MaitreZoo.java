package model;

public class MaitreZoo {
    private String nom;
    private boolean sexe;
    private int age;

    public void examinerEnclos(Enclos enclos){
        System.out.println(enclos);
    }

    public void nettoyerEnclos(Enclos enclos){
        enclos.nettoyer();
    }

    public void nourrir(Creature creature){
        creature.manger();
    }

    public void transferer(Creature creature, Enclos enclosDepart, Enclos enclosArrive){
        enclosDepart.retirerCreature(creature);
        enclosArrive.ajouterCreature(creature);
    }
}
