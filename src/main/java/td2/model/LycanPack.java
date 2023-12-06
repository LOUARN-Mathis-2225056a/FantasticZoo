package td2.model;

import td2.model.lycan.LycanthropeInPack;

import java.util.ArrayList;

public class LycanPack {
    private ArrayList<LycanthropeInPack> listLycan = new ArrayList<LycanthropeInPack>();
    private AlphaCouple alphaCouple;
    private Enclosure2 enclosure;
    public LycanPack(Enclosure2 enclosure) {
        this.enclosure = enclosure;
    }
    public Enclosure2 getEnclosure() {
        return enclosure;
    }
    public void removeLycan(LycanthropeInPack lycan){
        listLycan.remove(lycan);
    }

    public void setAlphaCouple(AlphaCouple alphaCouple) {
        this.alphaCouple = alphaCouple;
    }
}
