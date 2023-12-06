package td1.controller;

import td1.model.fantasticZoo.FantasticZoo;
import td1.view.ShowInTerminal;
import td1.view.ZooView;

public class ZooController {
    private static ZooController instance;

    public void showAllEnclosures(FantasticZoo zoo){
        ShowInTerminal.getInstance().showTitle("enclosure list");
        ZooView.getInstance().showAllEnclosure(zoo);
    }
    public void showAllCreatures(FantasticZoo zoo){
        ZooView.getInstance().showAllCreatures(zoo);
    }
    public void showTotalNumberOfCreature(FantasticZoo zoo){
        ZooView.getInstance().showNumberTotalOfCreature(zoo);
    }

    public static ZooController getInstance() {
        if(instance == null){
            instance = new ZooController();
        }
        return instance;
    }
}
