package td1.controller;

import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.fantasticZoo.FantasticZoo;
import td1.view.ZooMasterView;
import td1.view.ZooView;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMasterController {
    private static ZooMasterController instance;

    public static ZooMasterController getInstance() {
        if (instance == null) {
            instance = new ZooMasterController();
        }
        return instance;
    }

    public void execBehavior(FantasticZoo zoo) {
        while (true) {
            System.out.print("\033[H\033[2J"); // fonctionne peut être sur linux ?
            System.out.flush();
            zoo.showEnclosure();
            ZooMasterView.getInstance().showPrincipalMenu();
            Scanner actionChose = new Scanner(System.in);
            String action = actionChose.nextLine();
            switch (action) {
                case "1":
                    System.out.print("Choose your enclosure number to get its information : ");
                    Scanner enclosureInformationChoice = new Scanner(System.in);
                    String action2 = enclosureInformationChoice.nextLine();
                    int numEnclosureToGetInformationTo = Integer.parseInt(action2);
                    System.out.println(zoo.getEnclosureList().get(numEnclosureToGetInformationTo - 1).toString());
                    break;
                case "2":
                    System.out.print("Choose your enclosure number to clean : ");
                    Scanner enclosureCleanChoice = new Scanner(System.in);
                    String enclosureChoseToBeCleaned = enclosureCleanChoice.nextLine();
                    int numEnclosureToClean = Integer.parseInt(enclosureChoseToBeCleaned);
                    zoo.getEnclosureList().get(numEnclosureToClean - 1).clean();
                    break;
                case "3":
                    System.out.print("Choose your enclosure number to feed creature in enclosure : ");
                    Scanner enclosureFeedingChoice = new Scanner(System.in);
                    String enclosureToFeed = enclosureFeedingChoice.nextLine();
                    // waiting for message to enter
                    int numEnclosure = Integer.parseInt(enclosureToFeed);
                    zoo.getEnclosureList().get(numEnclosure - 1).addFood(250);
                    System.out.println("This enclosure has : " + zoo.getEnclosureList().get(numEnclosure - 1).getFeeder() + " food");
                    break;
                case "4":
                    // a implémenter j'ai vu le truc je suis devenu fou
            }
        }

    }

}
