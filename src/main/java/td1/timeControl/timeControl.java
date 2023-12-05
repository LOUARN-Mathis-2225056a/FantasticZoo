package td1.timeControl;

import td1.creature.Creature;
import td1.fantasticZoo.FantasticZoo;

public class timeControl implements Runnable{
    private boolean status = true;
    private FantasticZoo zoo;
    Thread time = new Thread(this);
    public timeControl(FantasticZoo zoo){
        this.zoo = zoo;
        time.start();
    }
    @Override
    public void run() {
        while(status){
            for (Creature creature : zoo.getAllCreatures()) {
                if(creature.getAge() == -1){
                    creature.getLife().notify();
                    creature.setName(creature.getParentName() + "'s child");
                }
                creature.setAge(creature.getAge()+1);
            }
        }
        try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void timePause(){status = false;}
    public void timeResume(){
        status = true;
        time = new Thread(this);
        time.start();
    }
}
