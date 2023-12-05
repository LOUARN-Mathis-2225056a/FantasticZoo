package model.fantasticZoo;

import model.creature.*;
import model.enclosure.*;
import model.getOperatingSystem.GetOperatingSystem;
import model.zooMaster.ZooMaster;

import java.io.IOException;
import java.util.ArrayList;

public class FantasticZoo {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<AbstractEnclosure<?>> listEnclosure = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // Pour avoir le résultat dans une autre fenetre
        if (GetOperatingSystem.getOperatingSystem().contains("Linux")) Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        else Runtime.getRuntime().exec("cmd /C Get-Content log -Wait ");

        // CREATURES
        Dragon drg1 = new Dragon("drg1",false,75,100,1);
        Dragon drg2 = new Dragon("drg2",true,75,100,1);

        Kraken kra1 = new Kraken("kra1",true,2,20,1);
        Kraken kra2 = new Kraken("kra2",true,2,20,1);

        Lycanthrope lyc1 = new Lycanthrope("kra1",false,5,30,1);
        Lycanthrope lyc2 = new Lycanthrope("kra2",false,5,30,1);

        Megalodon meg1 = new Megalodon("meg1",true,4000, 10000,1);
        Megalodon meg2 = new Megalodon("meg2",false,4000, 10000,1);

        Mermaid mer1 = new Mermaid("mer1",false,5,30,1);
        Mermaid mer2 = new Mermaid("mer2",false,5,30,1);

        Nymph nym1 = new Nymph("nym1",true,5,30,1);
        Nymph nym2 = new Nymph("nym2",true,5,30,1);

        Phoenix pho1 = new Phoenix("pho1",true,4,54,1);
        Phoenix pho2 = new Phoenix("pho2",false,4,54,1);

        Unicorn uni1 = new Unicorn("uni1",false,18,100,1);
        Unicorn uni2 = new Unicorn("uni2",true,18,100,1);

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
                "                               ------------------\n" +
                "                               | LIST ENCLOSURE |\n" +
                "                               ------------------\n");
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
