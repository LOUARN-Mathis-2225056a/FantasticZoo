package td1.model.fantasticZoo;


import td1.controller.GameSetup;
import td1.controller.ZooController;
import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.zooMaster.ZooMaster;
import td1.view.OpenNewTerminal;


import java.util.ArrayList;

public class FantasticZoo {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<AbstractEnclosure<?>> listEnclosure = new ArrayList<>();

    public FantasticZoo(String nom, ZooMaster zooMaster, int nbMaxEnclosure) {
        this.nom = nom;
        this.zooMaster = zooMaster;
        this.nbMaxEnclosure = nbMaxEnclosure;
    }
    public FantasticZoo(){}

    public static void main(String[] args) throws Exception {
        GameSetup.getInstance().setupZooMaster(new FantasticZoo());
        GameSetup.getInstance().setChooseGameMode();
        OpenNewTerminal.execute();

    }

    public ArrayList<AbstractEnclosure<?>> getEnclosureList() {
        return listEnclosure;
    }

    public void addEnclosure(AbstractEnclosure<?> enclosure) {
        listEnclosure.add(enclosure);
    }

    public void showEnclosure() {
        ZooController.getInstance().showAllEnclosures(this);
    }

    public void showNBCreature() {
        ZooController.getInstance().showTotalNumberOfCreature(this);
    }

    public void showCreature() {
        ZooController.getInstance().showAllCreatures(this);
    }

    public ArrayList<Creature> getAllCreatures() {
        ArrayList<Creature> lCreatures = new ArrayList<Creature>();
        for (AbstractEnclosure<?> abstractEnclosure : listEnclosure) {
            lCreatures.addAll(abstractEnclosure.getCreatureList());
        }
        return lCreatures;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }

    public void setNbMaxEnclosure(int nbMaxEnclosure) {
        this.nbMaxEnclosure = nbMaxEnclosure;
    }
}
