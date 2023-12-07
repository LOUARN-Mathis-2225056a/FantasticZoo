package td2.model.lycan;

import td2.model.Enclosure2;

public class LycanthropeSolitary extends Lycanthrope2 implements Runnable{
    Enclosure2 enclosure;
    public LycanthropeSolitary(boolean sex, AgeCategory age, int strength, int domination, int impetuosity, Enclosure2 enclosure) {
        super(sex, age, strength, domination, impetuosity);
        this.enclosure = enclosure;
        enclosure.addLycanSolitary(this);
        super.setThread(new Thread(this));
        super.startThread();
    }
    public LycanthropeSolitary(LycanthropeInPack lycanthropeInPack, Enclosure2 enclosure){
        super(  lycanthropeInPack.isSex(),
                lycanthropeInPack.getAge(),
                lycanthropeInPack.getStrength(),
                lycanthropeInPack.getDomination(),
                lycanthropeInPack.getImpetuosity());
        this.enclosure = enclosure;
        enclosure.addLycanSolitary(this);
        super.setThread(new Thread(this));
        super.startThread();
    }
    @Override
    public void run() {
        while (this.isOn()){
        }
    }
    public void setEnclosure(Enclosure2 enclosure) {
        this.enclosure.removeLycanSolitary(this);
        this.enclosure = enclosure;
        enclosure.addLycanSolitary(this);
    }

    public Enclosure2 getEnclosure() {
        return enclosure;
    }

    @Override
    public String toString(){
        return super.toString()
                + "             -enclosure number : " + enclosure.getID() + "\n";
    }

    @Override
    public void death() {
        super.setOn(false);
        enclosure.removeLycanSolitary(this);
    }

    public void goInPark(){
        enclosure.removeLycanSolitary(this);
        LycanthropeInPack newLycan = new LycanthropeInPack(this,enclosure.getLycanPack());
        super.setOn(false);
    }
}
