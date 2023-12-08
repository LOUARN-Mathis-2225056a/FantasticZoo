package td1.model.timeControl;

import td1.model.creature.Creature;
import td1.model.fantasticZoo.FantasticZoo;
import td1.view.fileWritter.FileWriter;

public class TimeControl implements Runnable{
    private boolean status = true;
    private final FantasticZoo zoo;
    Thread time = new Thread(this);
    public TimeControl(FantasticZoo zoo){
        this.zoo = zoo;
        time.start();
    }

    /**
     * The run needed to start a thread.
     * Defines how time changes the game
     */
    @Override
    public void run() {
        while(status){
            for (Creature creature : zoo.getAllCreatures()) {
                if(creature.getAge() == -1){
                    FileWriter.writeInFile(creature.getName() + " is coming to life !\n");
                    creature.getLife().notify();
                    creature.setName(creature.getParentName() + "'s child");
                }
                creature.setAge(creature.getAge()+1);
            }
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Pauses the time
     *
     * ZA WARUDO ! TOKI WO TOMARE !
     */
    public void timePause(){status = false;}

    /**
     * Resumes the time
     *
     * Toki wo Ugokidasu
     */
    public void timeResume(){
        status = true;
        time = new Thread(this);
        time.start();
    }
}