package td1.model.fantasticZoo;


import td1.controller.GameSetup;
import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.enclosure.Aquarium;
import td1.model.enclosure.Aviary;
import td1.model.zooMaster.ZooMaster;
import td1.view.OpenNewTerminal;


import java.io.IOException;
import java.util.ArrayList;

public class FantasticZoo {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<AbstractEnclosure<?>> listEnclosure = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        GameSetup.getInstance().setZooMasterName();
        GameSetup.getInstance().setChooseGameMode();
        OpenNewTerminal.execute();

    }
    public ArrayList<AbstractEnclosure<?>> getlistEnclosure() {
        return listEnclosure;
    }
    public void addEnclosure(AbstractEnclosure<?> enclosure){
        listEnclosure.add(enclosure);
    }
    public void showEnclosure(){
        int sizeOfListEnclosure = listEnclosure.size();
        System.out.println(
                """
                                                       ------------------
                                                       | LIST ENCLOSURE |
                                                       ------------------
                        """);
        int numberOfEnclosure = 1;
        String stringUpDown = "";
        String stringSide = "";
        String stringMid = "";
        for (AbstractEnclosure<?> enclosure : listEnclosure){
            stringSide += "|             | ";
            if (numberOfEnclosure<10){
                stringMid += "|      "+numberOfEnclosure+"      | ";
            }
            else{
                stringMid += "|     "+numberOfEnclosure+"      | ";
            }
            if (enclosure.getClass() == Aquarium.class){
                stringUpDown += "~~~~~~~~~~~~~~~ ";
            }
            else if (enclosure.getClass() == Aviary.class){
                stringUpDown += "ooooooooooooooo ";
            }
            else{
                stringUpDown += "--------------- ";
            }
            if (numberOfEnclosure%5 == 0 || numberOfEnclosure == sizeOfListEnclosure){
                System.out.println(stringUpDown);
                System.out.println(stringSide);
                System.out.println(stringMid);
                System.out.println(stringSide);
                System.out.println(stringUpDown);
                stringUpDown = "";
                stringMid = "";
                stringSide = "";
            }
            ++numberOfEnclosure;
        }
    }
    public void showNBCreature(){
        int count = 0;
        for (AbstractEnclosure<?> abstractEnclosure : listEnclosure){
            count += abstractEnclosure.getCreatureList().size();
        }
        System.out.println("There is a total die " + count + " in the zooFantastic");
    }
    public void showCreature(){
        for (AbstractEnclosure<?> abstractEnclosure : listEnclosure){
            for (Creature creature : abstractEnclosure.getCreatureList()){
                creature.shortToString();
            }
        }
    }
    public ArrayList<Creature> getAllCreatures(){
        ArrayList<Creature> lCreatures = new ArrayList<Creature>();
        for (AbstractEnclosure<?> abstractEnclosure : listEnclosure){
            lCreatures.addAll(abstractEnclosure.getCreatureList());
        }
        return lCreatures;
    }
}
