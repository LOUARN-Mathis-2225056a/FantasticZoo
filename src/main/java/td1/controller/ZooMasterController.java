package td1.controller;

import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.fantasticZoo.FantasticZoo;
import td1.model.zooMaster.ZooMaster;
import td1.view.ColorInTerminal;
import td1.view.ShowInTerminal;
import td1.view.ZooMasterView;
import td1.view.ZooView;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooMasterController {
    private static ZooMasterController instance;
    private ZooMaster zooMaster;
    private boolean isPlaying = true;

    public static ZooMasterController getInstance() {
        if (instance == null) {
            instance = new ZooMasterController();
        }
        return instance;
    }

    /**
     * How the game reacts to the number you choose
     *
     * @param zoo the current zoo
     */
    public void execBehavior(FantasticZoo zoo) {
        zooMaster = zoo.getZooMaster();
        while (isPlaying) {
            System.out.flush();
            zoo.showEnclosure();
            ZooMasterView.getInstance().showPrincipalMenu();
            Scanner actionChose = new Scanner(System.in);
            String action = actionChose.nextLine();
            switch (action) {
                case "1" -> {
                    System.out.print(ColorInTerminal.TEXT_YELLOW + "Choose your enclosure number to get its information : " + ColorInTerminal.TEXT_RESET);
                    Scanner enclosureInformationChoice = new Scanner(System.in);
                    String enclosureChosenToGetItsInformationFrom = enclosureInformationChoice.nextLine();
                    int numEnclosureToGetInformationTo = Integer.parseInt(enclosureChosenToGetItsInformationFrom);
                    System.out.println(zoo.getEnclosureList().get(numEnclosureToGetInformationTo - 1).toString());
                    System.out.println(ColorInTerminal.TEXT_YELLOW + "\nPress enter to continue" + ColorInTerminal.TEXT_RESET);
                    while (enclosureInformationChoice.nextLine() == null) {
                    }
                    ShowInTerminal.getInstance().refreshTerminal();
                }
                case "2" -> {
                    System.out.print(ColorInTerminal.TEXT_YELLOW + "Choose your enclosure number to clean : " + ColorInTerminal.TEXT_RESET);
                    Scanner enclosureCleanChoice = new Scanner(System.in);
                    String enclosureChoseToBeCleaned = enclosureCleanChoice.nextLine();
                    int numEnclosureToClean = Integer.parseInt(enclosureChoseToBeCleaned);
                    zoo.getEnclosureList().get(numEnclosureToClean - 1).clean();
                    System.out.println(ColorInTerminal.TEXT_YELLOW + "\nPress enter to continue"+ ColorInTerminal.TEXT_RESET);
                    while (enclosureCleanChoice.nextLine() == null) {
                    }
                    ShowInTerminal.getInstance().refreshTerminal();
                }
                case "3" -> {
                    System.out.print(ColorInTerminal.TEXT_YELLOW +  "Choose your enclosure number to feed creature in enclosure : "+ ColorInTerminal.TEXT_RESET);
                    Scanner enclosureFeedingChoice = new Scanner(System.in);
                    String enclosureToFeed = enclosureFeedingChoice.nextLine();
                    int numEnclosure = Integer.parseInt(enclosureToFeed);
                    zooMaster.feed(zoo.getEnclosureList().get(numEnclosure - 1), 250);
                    System.out.println(ColorInTerminal.TEXT_PURPLE + "This enclosure has : " + zoo.getEnclosureList().get(numEnclosure - 1).getFeeder() + " food" + ColorInTerminal.TEXT_RESET );
                    System.out.println(ColorInTerminal.TEXT_YELLOW + "\nPress enter to continue"+ColorInTerminal.TEXT_RESET);
                    while (enclosureFeedingChoice.nextLine() == null) {
                    }
                    ShowInTerminal.getInstance().refreshTerminal();
                }
                case "4" -> {
                    try {
                        ZooView.getInstance().showAllEnclosure(zoo);
                        System.out.print(ColorInTerminal.TEXT_YELLOW + "Choose the enclosure you want to transfer (type the number) :");
                        Scanner enclosureNumberToTransfer = new Scanner(System.in);
                        int enclosureNumberChosenToBeTransferred = Integer.parseInt(enclosureNumberToTransfer.nextLine());
                        AbstractEnclosure<?> enclosureToTransfer = zoo.getEnclosureList().get(enclosureNumberChosenToBeTransferred - 1);
                        System.out.print(ColorInTerminal.TEXT_YELLOW + "Choose the targeted enclosure (type the number) :");
                        Scanner enclosureNumberTarget = new Scanner(System.in);
                        int enclosureNumberChosenAsTarget = Integer.parseInt(enclosureNumberTarget.nextLine());
                        AbstractEnclosure<?> enclosureTarget = zoo.getEnclosureList().get(enclosureNumberChosenAsTarget - 1);
                        zoo.getZooMaster().transferAllCreatures(enclosureToTransfer, enclosureTarget);
                        System.out.println(ColorInTerminal.TEXT_YELLOW + "\nPress enter to continue");
                    }catch (Exception e){
                        System.out.println(ColorInTerminal.TEXT_RED +"The chosen enclosure does not exist" + ColorInTerminal.TEXT_RESET);
                    }
                    Scanner enclosureNumberToTransfer = new Scanner(System.in);
                    while (enclosureNumberToTransfer.nextLine() == null) {
                    }
                    ShowInTerminal.getInstance().refreshTerminal();
                }
                case "5" ->{
                    ZooMasterView.getInstance().goodbye();
                    isPlaying = false;
                    zooMaster.stopTheGame();
                }
                default -> {System.out.println(ColorInTerminal.TEXT_RED + "Select a valid option !" + ColorInTerminal.TEXT_YELLOW);
                    Scanner wait = new Scanner(System.in);
                    System.out.print("Press enter to continue" + ColorInTerminal.TEXT_RESET);
                    while (wait.nextLine() == null) {
                    }
                    ShowInTerminal.getInstance().refreshTerminal();
                }
            }
        }

    }

}
