package td1.controller;

import td1.model.fantasticZoo.FantasticZoo;
import td1.view.ColorInTerminal;
import td1.view.ShowInTerminal;
import td1.view.ZooView;

public class ZooController {
    private static ZooController instance;

    public static ZooController getInstance() {
        if (instance == null) {
            instance = new ZooController();
        }
        return instance;
    }

    /**
     * Show all the enclosures
     *
     * @param zoo the zoo where you take all enclosures
     */
    public void showAllEnclosures(FantasticZoo zoo) {
        System.out.print(ColorInTerminal.TEXT_PURPLE);
        ShowInTerminal.getInstance().showTitle("enclosure list");
        ZooView.getInstance().showAllEnclosure(zoo);
        System.out.print(ColorInTerminal.TEXT_RESET);
    }

    /**
     * Show all the creatures in a zoo
     *
     * @param zoo the zoo where you take all creatures
     */
    public void showAllCreatures(FantasticZoo zoo) {
        ZooView.getInstance().showAllCreatures(zoo);
    }

    /**
     * Show the total number of creatures
     *
     * @param zoo the zoo where you take all creatures
     */
    public void showTotalNumberOfCreature(FantasticZoo zoo) {
        ZooView.getInstance().showNumberTotalOfCreature(zoo);
    }
}
