package model.zooMaster;

import model.creature.Creature;
import model.enclosure.AbstractEnclosure;
import model.enclosure.Enclosure;
import model.fantasticZoo.FantasticZoo;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMaster implements Runnable{
    private String name;
    private boolean sex;
    private int age;
    private FantasticZoo myZoo;

    public ZooMaster(String name, boolean sex, int age, FantasticZoo myZoo) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.myZoo = myZoo;
    }

    public void run() {
        while (true){
            System.out.print("\033[H\033[2J"); // fonctionne peut être sur linux ?
            System.out.flush();
            System.out.println(
                            "                               ---------------------\n" +
                            "                               | ACTION ZOO MASTER |\n" +
                            "                               ---------------------\n" +
                            "To perform an action you must enter the text:\n" +
                            "    - \"CheckEnclosure\" to be able to select the enclosure you want to see.\n" +
                            "    - \"CleanEnclosure\" to be able to select the enclusure you want clean.\n" +
                            "    - \"Feed\" to be able to select the creature you want feed.\n" +
                            "    - \"Transfer\" to be able to select the creature you want transfer."
            );
            Scanner textIn = new Scanner(System.in);
            String action = textIn.nextLine();

            // waiting for message to enter
            while (action.equals(null)){}
            myZoo.showEnclosure();
            ArrayList<AbstractEnclosure<?>> listEnclosure = myZoo.getListAbstractEnclosures();
            if (action.equals("CheckEnclosure")){
                System.out.print("Choose your enclosure number to get its information : ");
                Scanner textIn2 = new Scanner(System.in);
                String action2 = textIn.nextLine();
                // waiting for message to enter
                while (action2.equals(null)){}
                int numEnclosure = Integer.parseInt(action2);
                System.out.println(listEnclosure.get(numEnclosure-1).toString());

            } else if (action.equals("CleanEnclosure")) {
                System.out.print("Choose your enclosure number to clean : ");
                Scanner textIn2 = new Scanner(System.in);
                String action2 = textIn.nextLine();
                // waiting for message to enter
                while (action2.equals(null)){}
                int numEnclosure = Integer.parseInt(action2);
                if (listEnclosure.get(numEnclosure-1).getCreatureList().isEmpty()){
                    listEnclosure.get(numEnclosure-1).clean(3);
                    System.out.println("This enclosure is clean !");
                }
                else {
                    System.out.println("This enclosure is not empty!");
                }

            } else if (action.equals("Feed")) {
                System.out.print("Choose your enclosure number to feed creature in enclosure : ");
                Scanner textIn2 = new Scanner(System.in);
                String action2 = textIn.nextLine();
                // waiting for message to enter
                while (action2.equals(null)){}
                int numEnclosure = Integer.parseInt(action2);
                listEnclosure.get(numEnclosure-1).addFood(250);
                System.out.println("This enclosure has : " + listEnclosure.get(numEnclosure-1).getFeeder() + " food");

            }else if (action.equals("Transfer")) {
                System.out.print("Choose your enclosure number one : ");
                Scanner textIn2 = new Scanner(System.in);
                String action2 = textIn.nextLine();
                // waiting for message to enter
                while (action2.equals(null)){}
            }else{
                System.out.println("This is not an action possible, pay attention to capital letters and spaces.\n");
            }
            for (int i=0; i<100;++i){
                System.out.println("\n");
            }
        }
    }

    public void checkEnclosure(AbstractEnclosure abstractEnclosure){
        System.out.println(abstractEnclosure);
    }

    public void cleanEnclosure(AbstractEnclosure abstractEnclosure, int cleanlinessLevel){
        abstractEnclosure.clean(cleanlinessLevel);
    }

    public void feed(Enclosure enclosure, int quantity){
        enclosure.addFood(quantity);}

    public void transfer(Creature creature, AbstractEnclosure abstractEnclosureFrom, AbstractEnclosure abstractEnclosureTarget) throws Exception {
        abstractEnclosureFrom.removeCreature(creature);
        abstractEnclosureTarget.addCreature(creature);
    }
}
