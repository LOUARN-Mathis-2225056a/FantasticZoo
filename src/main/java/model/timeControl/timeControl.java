package model.timeControl;

import model.creature.Creature;
import model.fantasticZoo.FantasticZoo;

import java.util.ArrayList;

public class timeControl implements Runnable{
    private boolean status = true;
    private ArrayList<Creature> creatureList;

    private FantasticZoo zoo;
    public timeControl(FantasticZoo zoo){
        this.zoo = zoo;
        Thread time = new Thread(this);
        time.start();
    }
    @Override
    public void run() {
        while(status){

        }
    }
    public void timePause(){
        status = false;
    }
    public void timeResume(){
        status = true;
    }
}
