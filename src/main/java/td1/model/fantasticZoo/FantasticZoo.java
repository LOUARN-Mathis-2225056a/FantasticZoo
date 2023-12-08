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

    /**
     * Returns the list of enclosures in the zoo
     *
     * @return the list of enclosures in the zoo
     */
    public ArrayList<AbstractEnclosure<?>> getEnclosureList() {
        return listEnclosure;
    }

    /**
     * Add an enclosure in the zoo
     *
     * @param enclosure the enclosure to add in the zoo
     */
    public void addEnclosure(AbstractEnclosure<?> enclosure) {
        listEnclosure.add(enclosure);
    }

    /**
     * Shows all the enclosures in the zoo
     */
    public void showEnclosure() {
        ZooController.getInstance().showAllEnclosures(this);
    }

    /**
     * Shows the number of creatures in the zoo
     */
    public void showNBCreature() {
        ZooController.getInstance().showTotalNumberOfCreature(this);
    }

    /**
     * Shows all the creatures in the zoo
     */
    public void showCreature() {
        ZooController.getInstance().showAllCreatures(this);
    }

    /**
     * Return a list of all creatures in the zoo
     *
     * @return the list of all creatures in the zoo
     */
    public ArrayList<Creature> getAllCreatures() {
        ArrayList<Creature> lCreatures = new ArrayList<Creature>();
        for (AbstractEnclosure<?> abstractEnclosure : listEnclosure) {
            lCreatures.addAll(abstractEnclosure.getCreatureList());
        }
        return lCreatures;
    }

    /**
     * Sets the name of the zoo
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.nom = name;
    }

    /**
     * Sets the master of the zoo
     *
     * @param zooMaster the zoomaster
     */
    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }

    /**
     * Returns the zoomaster
     *
     * @return the zoomaster
     */
    public ZooMaster getZooMaster() {
        return zooMaster;
    }

    /**
     * Sets the max number of enclosures
     *
     * @param nbMaxEnclosure the new max number
     */
    public void setNbMaxEnclosure(int nbMaxEnclosure) {
        this.nbMaxEnclosure = nbMaxEnclosure;
    }
}
