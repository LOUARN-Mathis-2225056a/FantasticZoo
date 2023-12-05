package td2.model.lycan;

import td2.model.Enclosure2;

public class LycanthropeSolitary extends Lycanthrope2 implements Runnable{
    Enclosure2 enclosure;
    public LycanthropeSolitary(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity, Enclosure2 enclosure) {
        super(sex, age, strength, domination, level, impetuosity);
        setEnclosure(enclosure);
        super.setThread(new Thread(this));
        super.startThread();
    }
    public LycanthropeSolitary(LycanthropeEnMeute lycanthropeEnMeute,Enclosure2 enclosure){
        super(  lycanthropeEnMeute.isSex(),
                lycanthropeEnMeute.getAge(),
                lycanthropeEnMeute.getStrength(),
                lycanthropeEnMeute.getDomination(),
                lycanthropeEnMeute.getLevel(),
                lycanthropeEnMeute.getImpetuosity());
        setEnclosure(enclosure);
        super.setThread(new Thread(this));
        super.startThread();
    }
    @Override
    public void run() {
        while (this.isOn()){
        }
    }
    public void setEnclosure(Enclosure2 enclosure) {
        this.enclosure = enclosure;
        enclosure.addLycanSolitary(this);
    }
    @Override
    public String toString(){
        return super.toString()
                + "             -enclosure number : " + enclosure.getID() + "\n";
    }
}
