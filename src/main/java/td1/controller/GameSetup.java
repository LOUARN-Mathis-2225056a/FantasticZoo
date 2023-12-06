package td1.controller;

import td1.model.creature.*;
import td1.model.enclosure.Aquarium;
import td1.model.enclosure.Aviary;
import td1.model.enclosure.Enclosure;
import td1.model.fantasticZoo.FantasticZoo;
import td1.model.timeControl.TimeControl;
import td1.model.zooMaster.ZooMaster;
import td1.view.ShowInTerminal;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSetup {
    private static GameSetup instance;

    private String zooMasterName;

    public void setZooMasterName() {
        System.out.print("Choose your name : ");
        Scanner textIn = new Scanner(System.in);
        zooMasterName = textIn.nextLine();
    }

    public void setChooseGameMode() throws Exception {
        ShowInTerminal.getInstance().showWelcomeMessage();
        Scanner textIn = new Scanner(System.in);
        int gameMode = Integer.parseInt(textIn.nextLine());
        switch (gameMode) {
            case 1 -> execGroundOnlyScenario();
            case 2 -> execFlyerOnlyScenario();
            case 3 -> execSwimmerOnlyScenario();
        }
    }

    private void execGroundOnlyScenario() {
        FantasticZoo fantasticZoo = new FantasticZoo();
        ZooMaster zooMaster = new ZooMaster(zooMasterName, false, 18, fantasticZoo);
        Thread game = new Thread(zooMaster);

        ArrayList<Creature> creatureList = new ArrayList<>();

        creatureList.add(new Lycanthrope("Lycanthrope 1", false, 50, 12, 0));
        creatureList.add(new Lycanthrope("Lycanthrope 2", true, 60, 15, 0));
        Enclosure enclosure1 = new Enclosure("Alpha", 500, 10);
        enclosure1.addAllCreatures(creatureList);

        creatureList.clear();
        creatureList.add(new Nymph("Nymph 1", false, 5, 30, 1));
        creatureList.add(new Nymph("Nymph 2", true, 5, 30, 1));
        Enclosure enclosure2 = new Enclosure("Bravo", 500, 10);
        enclosure2.addAllCreatures(creatureList);

        creatureList.clear();
        creatureList.add(new Unicorn("Unicorn 1", false, 18, 100, 1));
        creatureList.add(new Unicorn("Unicorn 2", true, 18, 100, 1));
        Enclosure enclosure3 = new Enclosure("Charlie", 500, 10);
        enclosure3.addAllCreatures(creatureList);

        fantasticZoo.addEnclosure(enclosure1);
        fantasticZoo.addEnclosure(enclosure2);
        fantasticZoo.addEnclosure(enclosure3);

        TimeControl time = new TimeControl(fantasticZoo);

        game.start();
    }

    private void execFlyerOnlyScenario() throws Exception {
        FantasticZoo fantasticZoo = new FantasticZoo();
        ZooMaster zooMaster = new ZooMaster(zooMasterName, false, 18, fantasticZoo);
        Thread game = new Thread(zooMaster);

        ArrayList<Creature> creatureList = new ArrayList<>();

        creatureList.add(new Dragon("Dragon 1", false, 200, 80, 1));
        creatureList.add(new Dragon("Dragon 2", true, 250, 100, 1));
        Aviary aviary1 = new Aviary("Alpha", 500, 10, 100);
        aviary1.addAllCreatures(creatureList);

        creatureList.clear();
        creatureList.add(new Phoenix("Phoenix 1", false, 90, 54, 1));
        creatureList.add(new Phoenix("Phoenix 2", true, 80, 54, 1));
        Aviary aviary2 = new Aviary("Bravo", 500, 10, 50);
        aviary2.addAllCreatures(creatureList);

        fantasticZoo.addEnclosure(aviary1);
        fantasticZoo.addEnclosure(aviary2);

        TimeControl time = new TimeControl(fantasticZoo);

        game.start();
    }

    private void execSwimmerOnlyScenario() throws Exception {
        FantasticZoo fantasticZoo = new FantasticZoo();
        ZooMaster zooMaster = new ZooMaster(zooMasterName, false, 18, fantasticZoo);
        Thread game = new Thread(zooMaster);

        ArrayList<Creature> creatureList = new ArrayList<>();

        creatureList.add(new Kraken("Kraken 1", true, 2, 20, 1));
        creatureList.add(new Kraken("Kraken 2", false, 2, 20, 1));
        Aquarium aquarium1 = new Aquarium("Alpha", 1000, 10, 100, 35);
        aquarium1.addAllCreatures(creatureList);

        creatureList.clear();
        creatureList.add(new Megalodon("Megalodon 1", true, 4000, 10000, 1));
        creatureList.add(new Megalodon("Megalodon 2", false, 4000, 10000, 1));
        Aquarium aquarium2 = new Aquarium("Bravo", 700, 10, 70, 25);
        aquarium2.addAllCreatures(creatureList);

        creatureList.clear();
        creatureList.add(new Mermaid("Mermaid 1", true, 5, 30, 1));
        creatureList.add(new Mermaid("Mermaid 2", false, 5, 30, 1));
        Aquarium aquarium3 = new Aquarium("Charlie", 300, 10, 20, 10);
        aquarium3.addAllCreatures(creatureList);

        fantasticZoo.addEnclosure(aquarium1);
        fantasticZoo.addEnclosure(aquarium2);
        fantasticZoo.addEnclosure(aquarium3);

        TimeControl time = new TimeControl(fantasticZoo);

        game.start();
    }

    public static GameSetup getInstance() {
        if (instance == null) {
            instance = new GameSetup();
        }
        return instance;
    }
}
