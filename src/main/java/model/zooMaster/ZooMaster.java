package model.zooMaster;

import model.creature.Creature;
import model.enclosure.AbstractEnclosure;
import model.enclosure.Aquarium;
import model.enclosure.Aviary;
import model.enclosure.Enclosure;
import model.fantasticZoo.FantasticZoo;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMaster implements Runnable{
    private String name;
    private boolean sexe;
    private int age;
    private FantasticZoo myZoo;

    public ZooMaster(String name, boolean sexe, int age, FantasticZoo myZoo) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
        this.myZoo = myZoo;
    }

    public void run() {
        while (true){
            System.out.print("\033[H\033[2J"); // fonctionne peut être sur linux ?
            System.out.flush();
            System.out.println(
                            "       ---------------------\n" +
                            "       | ACTION ZOO MASTER |\n" +
                            "       ---------------------\n" +
                            "To perform an action you must enter the text:\n" +
                            "    - \"CheckEnclosure\" to be able to select the enclosure you want to see.\n" +
                            "    - \"CleanEnclosure\" to be able to select the enclusure you want clean.\n" +
                            "    - \"Feed\" to be able to select the creature you want feed.\n" +
                            "    - \"Transfer\" to be able to select the creature you want transfer."
            );
            Scanner textIn = new Scanner(System.in);
            String action = textIn.nextLine();

            // waiting for message to enter
            while (action.equals(null)){
            }

            if (action.equals("CheckEnclosure")){
                ArrayList<AbstractEnclosure> listEnclosure = myZoo.getListAbstractEnclosures();
                int sizeOfListEnclosure = listEnclosure.size();
                System.out.println(
                                "       ------------------\n" +
                                "       | LIST ENCLOSURE |\n" +
                                "       ------------------\n");
                for (AbstractEnclosure enclosure : listEnclosure){
                    if (enclosure.getClass() == Aquarium.class){
                        System.out.println("Aquarium");
                    }
                    else if (enclosure.getClass() == Aviary.class){
                        System.out.println("Aviary");
                    }
                    else{
                        System.out.println("Enclosure");
                    }
                }

            } else if (action.equals("CleanEnclosure")) {

            } else if (action.equals("Feed")) {

            }else if (action.equals("Transfer")) {

            }else{
                System.out.println("This is not an action possible, pay attention to capital letters and spaces.\n");
            }
        }
    }

    public void checkEnclosure(AbstractEnclosure abstractEnclosure){
        System.out.println(abstractEnclosure);
    }

    public void cleanEnclosure(AbstractEnclosure abstractEnclosure, int cleanlinessLevel){
        abstractEnclosure.clean(cleanlinessLevel);
    }

    public void feed(Creature creature){
        creature.eat();
    }

    public void transfer(Creature creature, AbstractEnclosure abstractEnclosureFrom, AbstractEnclosure abstractEnclosureTarget) throws Exception {
        abstractEnclosureFrom.removeCreature(creature);
        abstractEnclosureTarget.addCreature(creature);
    }
}
