package td2.model;

import td2.controller.LycanthropeColony;
import td2.model.lycan.LycanthropeSolitary;

import java.util.ArrayList;

public class Enclosure2 {
    private LycanPack lycanPack;
    private int ID;
    static int nbEnclosure = 0;
    private ArrayList<LycanthropeSolitary> listSolitary;
    private LycanthropeColony lycanthropeColony;
    public Enclosure2(LycanthropeColony lycanthropeColony){
        lycanPack = new LycanPack(this);
        listSolitary = new ArrayList<LycanthropeSolitary>();
        nbEnclosure+=1;
        ID = nbEnclosure;
        this.lycanthropeColony = lycanthropeColony;
    }

    public LycanthropeColony getLycanthropeColony() {
        return lycanthropeColony;
    }
    public LycanPack getLycanPack() {
        return lycanPack;
    }
    public ArrayList<LycanthropeSolitary> getListSolitary() {
        return listSolitary;
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
