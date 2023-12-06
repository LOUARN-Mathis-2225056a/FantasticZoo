package td2.model.lycan;

import td2.model.LycanPack;

public class LycanthropeEnMeute extends Lycanthrope2 implements Runnable{
    private String rank;
    private LycanPack lycanPack;
    @Override
    public void run() {
        while (this.isOn()){
        }
    }
    public LycanthropeEnMeute(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity,String rank,LycanPack lycanPack) {
        super(sex, age, strength, domination, level, impetuosity);
        this.rank = rank;
        this.lycanPack = lycanPack;
        super.setThread(new Thread(this));
        super.startThread();
    }

    public LycanPack getLycanPack() {
        return lycanPack;
    }

    @Override
    public String toString(){
        return super.toString()
                + "             -rank : " + rank + "\n"
                + "             -enclosure number : " + lycanPack.getEnclosure().getID() + "\n";
    }
    public void leaveLycanPack(){
        lycanPack.removeLycan(this);
        LycanthropeSolitary newLycan = new LycanthropeSolitary(this,lycanPack.getEnclosure());
        this.setOn(false);
    }
}
