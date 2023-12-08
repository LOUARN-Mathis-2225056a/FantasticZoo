package td2.model.lycan;

import td2.model.Enclosure2;
import td2.model.LycanPack;
import td2.model.roar.Aggressiveness;
import td2.model.roar.Domination;
import td2.model.roar.Roar;
import td2.model.roar.Submission;

import java.util.ArrayList;
import java.util.Random;

public class LycanthropeInPack extends Lycanthrope2 implements Runnable{
    private int rank;
    private LycanPack lycanPack;
    @Override
    public void run() {
        while (this.isOn()){
            // DOMINATION TEST
            Random rd = new Random();
            if(101 - rd.nextInt(getImpetuosity()) == 100){
                LycanthropeInPack target = lycanPack.getListLycan().get(rd.nextInt(lycanPack.getListLycan().size()));
                if ( !(target.isSex() && target.rank == 1) // verification that we do not attack the alpha female
                        && target.getStrength()<=getStrength() - rd.nextInt(3) // force estimation
                        && target != this // verification that we are not attacking ourselves
                        && (target.getRank() != 1 && isSex())){ // verification that a female is not trying to take the place of male alpha
                    target.setLevelPack();
                    setLevelPack();
                    emitHowl(new Domination());
                    System.out.println("---- AGGRESSOR ----");
                    showToString();
                    System.out.println("---- TARGET ----");
                    target.showToString();
                    if (getLevel()>target.getLevel() || target.getRank() == 24){
                        emitHowl(new Aggressiveness());
                        target.emitHowl(new Submission());
                        setDomination(getDomination()+1);
                        target.setDomination(target.getDomination()-1);
                        if (rank>target.getRank()){
                            int rankTarget = target.getRank();
                            target.setRank(rankTarget);
                            setRank(rankTarget);
                            if (rank == 1){
                                lycanPack.getAlphaCouple().getFemale().setRank(rankTarget); // so that the female follows the rank of her husband
                                lycanPack.setBestFemale();
                            }
                        }
                    }
                    else {
                        target.emitHowl(new Aggressiveness());
                        emitHowl(new Submission());
                        setDomination(getDomination()-1);
                        target.setDomination(target.getDomination()+1);
                    }
                    System.out.println("---- AGGRESSOR ----");
                    showToString();
                    System.out.println("---- TARGET ----");
                    target.showToString();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public LycanthropeInPack(boolean sex, AgeCategory age, int domination, int rank, LycanPack lycanPack) {
        super(sex, age, domination);
        this.rank = rank;
        setLevelPack();
        this.lycanPack = lycanPack;
        lycanPack.addLycan(this);
        super.setThread(new Thread(this));
        super.startThread();
    }
    public LycanthropeInPack(LycanthropeSolitary lycanthropeSolitary, LycanPack lycanPack){
        super(  lycanthropeSolitary.isSex(),
                lycanthropeSolitary.getAge(),
                lycanthropeSolitary.getDomination());
        this.lycanPack = lycanPack;
        lycanPack.addLycan(this);
        rank = 1;
        setLevelPack();
        super.setThread(new Thread(this));
        super.startThread();
    }
    public void setLevelPack(){
        super.setLevel();
        addIntLevel(24-rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public LycanPack getLycanPack() {
        return lycanPack;
    }
    public String getStringRank(){
        ArrayList<String> listAlphabetGrec = new ArrayList<>();
        listAlphabetGrec.add("α");
        listAlphabetGrec.add("β");
        listAlphabetGrec.add("γ");
        listAlphabetGrec.add("δ");
        listAlphabetGrec.add("ε");
        listAlphabetGrec.add("ζ");
        listAlphabetGrec.add("η");
        listAlphabetGrec.add("θ");
        listAlphabetGrec.add("ι");
        listAlphabetGrec.add("κ");
        listAlphabetGrec.add("λ");
        listAlphabetGrec.add("μ");
        listAlphabetGrec.add("ν");
        listAlphabetGrec.add("ξ");
        listAlphabetGrec.add("ο");
        listAlphabetGrec.add("π");
        listAlphabetGrec.add("ρ");
        listAlphabetGrec.add("σ");
        listAlphabetGrec.add("τ");
        listAlphabetGrec.add("υ");
        listAlphabetGrec.add("Φ");
        listAlphabetGrec.add("χ");
        listAlphabetGrec.add("ψ");
        listAlphabetGrec.add("ω");
        return listAlphabetGrec.get(rank-1);
    }
    @Override
    public String toString(){
        return super.toString()
                + "             -rank : " + getStringRank() + "\n"
                + "             -enclosure number : " + lycanPack.getEnclosure().getID() + "\n";
    }
    @Override
    public void death() {
        super.setOn(false);
        lycanPack.removeLycan(this);
    }
    public void leaveLycanPack(){
        lycanPack.removeLycan(this);
        LycanthropeSolitary newLycan = new LycanthropeSolitary(this,lycanPack.getEnclosure());
        this.setOn(false);
    }
}
