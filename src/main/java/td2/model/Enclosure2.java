package td2.model;

import td2.model.lycan.LycanthropeSolitary;

import java.util.ArrayList;

public class Enclosure2 {
    private LycanPack lycanPack;
    private int ID;
    static int nbEnclosure = 0;
    private ArrayList<LycanthropeSolitary> listSolitary = new ArrayList<>();

    public Enclosure2(){
        nbEnclosure+=1;
        ID = nbEnclosure;
    }

    public LycanPack getLycanPack() {
        return lycanPack;
    }
    public void addLycanSolitary(LycanthropeSolitary lycan){
        listSolitary.add(lycan);
    }
    public void removeLycanSolitary(LycanthropeSolitary lycan){
        listSolitary.remove(lycan);
    }
    public int getID(){
        return ID;
    }
}
