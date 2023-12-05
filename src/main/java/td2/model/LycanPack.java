package td2.model;

import td2.model.lycan.LycanthropeEnMeute;

import java.util.ArrayList;

public class LycanPack {
    private ArrayList<LycanthropeEnMeute> listLycan = new ArrayList<LycanthropeEnMeute>();
    private Enclosure2 enclosure;

    public Enclosure2 getEnclosure() {
        return enclosure;
    }
    public LycanPack(Enclosure2 enclosure) {
        this.enclosure = enclosure;
    }
    public void removeLycan(LycanthropeEnMeute lycan){
        listLycan.remove(lycan);
    }
}
