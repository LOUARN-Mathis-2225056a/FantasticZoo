package td1.controller;

import td1.model.fantasticZoo.FantasticZoo;
import td1.view.ShowInTerminal;

public class ZooController {
    private static ZooController instance;

    public void showEnclosure(FantasticZoo zoo){
        ShowInTerminal.getInstance().showTitle("enclosure list");
        int sizeOfListEnclosure = zoo.getlistEnclosure().size();

    }

    public static ZooController getInstance() {
        if(instance == null){
            instance = new ZooController();
        }
        return instance;
    }
}
