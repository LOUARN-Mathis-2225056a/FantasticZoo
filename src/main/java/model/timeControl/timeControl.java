package model.timeControl;

import model.creature.Creature;
import model.fantasticZoo.FantasticZoo;

import javax.xml.datatype.Duration;
import java.util.ArrayList;

public class timeControl implements Runnable{
    private boolean status = true;
    private FantasticZoo zoo;
    public timeControl(FantasticZoo zoo){
        this.zoo = zoo;
        Thread time = new Thread(this);
        time.start();
    }
    @Override
    public void run() {
        while(status){
            for (Creature creature : zoo.getAllCreatures()) {
                creature.setAge(creature.getAge()+1);
            }
        }
        try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void timePause(){
        status = false;
    }
    public void timeResume(){
        status = true;
        run();
    }
}
