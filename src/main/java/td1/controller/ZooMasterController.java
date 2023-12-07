package td1.controller;

import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.fantasticZoo.FantasticZoo;
import td1.model.zooMaster.ZooMaster;
import td1.view.ZooMasterView;
import td1.view.ZooView;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMasterController {
    private static ZooMasterController instance;

    private ZooMaster zooMaster;

    public static ZooMasterController getInstance() {
        if (instance == null) {
            instance = new ZooMasterController();
        }
        return instance;
    }

    public void execBehavior(FantasticZoo zoo) {
        zooMaster = zoo.getZooMaster();
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
                    String enclosureChosenToGetItsInformationFrom = enclosureInformationChoice.nextLine();
                    int numEnclosureToGetInformationTo = Integer.parseInt(enclosureChosenToGetItsInformationFrom);
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
                    zooMaster.feed(zoo.getEnclosureList().get(numEnclosure - 1),250);
                    System.out.println("This enclosure has : " + zoo.getEnclosureList().get(numEnclosure - 1).getFeeder() + " food");
                    break;
                case "4":
                    ZooView.getInstance().showAllEnclosure(zoo);
                    System.out.print("Choose the enclosure you want to transfer (type the number) :");
                    Scanner enclosureNumberToTransfer = new Scanner(System.in);
                    int enclosureNumberChosenToBeTransferred = Integer.parseInt(enclosureNumberToTransfer.nextLine());
                    AbstractEnclosure<?> enclosureToTransfer = zoo.getEnclosureList().get(enclosureNumberChosenToBeTransferred - 1);

                    System.out.print("Choose the targeted enclosure (type the number) :");
                    Scanner enclosureNumberTarget = new Scanner(System.in);
                    int enclosureNumberChosenAsTarget = Integer.parseInt(enclosureNumberTarget.nextLine());
                    AbstractEnclosure<?> enclosureTarget = zoo.getEnclosureList().get(enclosureNumberChosenAsTarget - 1);

                    zoo.getZooMaster().transferAllCreatures(enclosureToTransfer,enclosureTarget);
                    break;
            }
        }

    }

}
