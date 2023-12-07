package td2.model.lycan;

import td2.model.Enclosure2;
import td2.model.LycanPack;

import java.util.ArrayList;

public class LycanthropeInPack extends Lycanthrope2 implements Runnable{
    private int rank;
    private LycanPack lycanPack;
    @Override
    public void run() {
        while (this.isOn()){
        }
    }
    public LycanthropeInPack(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity, int rank, LycanPack lycanPack) {
        super(sex, age, strength, domination, level, impetuosity);
        this.rank = rank;
        this.lycanPack = lycanPack;
        lycanPack.addLycan(this);
        super.setThread(new Thread(this));
        super.startThread();
    }
    public LycanthropeInPack(LycanthropeSolitary lycanthropeSolitary, LycanPack lycanPack){
        super(  lycanthropeSolitary.isSex(),
                lycanthropeSolitary.getAge(),
                lycanthropeSolitary.getStrength(),
                lycanthropeSolitary.getDomination(),
                lycanthropeSolitary.getLevel(),
                lycanthropeSolitary.getImpetuosity());
        this.lycanPack = lycanPack;
        lycanPack.addLycan(this);
        rank = 1;
        super.setThread(new Thread(this));
        super.startThread();
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
