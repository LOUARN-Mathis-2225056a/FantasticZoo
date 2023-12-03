package model.fantasticZoo;

import model.creature.*;
import model.enclosure.*;
import model.zooMaster.ZooMaster;

import java.io.IOException;
import java.util.ArrayList;

public class FantasticZoo {
    private String nom;
    private ZooMaster zooMaster;
    private int nbMaxEnclosure;
    private ArrayList<AbstractEnclosure> listAbstractEnclosures = new ArrayList<AbstractEnclosure>();

    public static void main(String[] args) throws IOException {

        // Pour avoir le résultat dans une autre fenetre
        //Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        Runtime.getRuntime().exec("cmd /c start cmd.exe");

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
    public ArrayList<AbstractEnclosure> getListAbstractEnclosures() {
        return listAbstractEnclosures;
    }
    public void addEnclosure(AbstractEnclosure enclosure){
        listAbstractEnclosures.add(enclosure);
    }
    public void showEnclosure(){
        int sizeOfListEnclosure = listAbstractEnclosures.size();
        System.out.println(
                "                               ------------------\n" +
                        "                               | LIST ENCLOSURE |\n" +
                        "                               ------------------\n");
        int numberOfEnclosure = 1;
        String stringUpDown = new String();
        String stringSide = new String();
        String stringMid = new String();
        for (AbstractEnclosure enclosure : listAbstractEnclosures){
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
        for (AbstractEnclosure abstractEnclosure : listAbstractEnclosures){
            count += abstractEnclosure.getCreatureList().size();
        }
        System.out.println("There is a total die " + count + " in the zooFantastic");
    }
    public void showCreature(){
        for (AbstractEnclosure abstractEnclosure : listAbstractEnclosures){
            for (Creature creature : abstractEnclosure.getCreatureList()){
                creature.toString();
            }
        }
    }
    public ArrayList<Creature> getAllCreatures(){
        ArrayList<Creature> lCreatures = new ArrayList<Creature>();
        for (AbstractEnclosure abstractEnclosure : listAbstractEnclosures){
            for (Creature creature : abstractEnclosure.getCreatureList()){
                lCreatures.add(creature);
            }
        }
        return lCreatures;
    }
}
