package td2.model;

import td2.model.lycan.LycanthropeSolitary;

import java.util.ArrayList;

public class Enclosure2 {
    private LycanPack lycanPack;
    private int ID;
    static int nbEnclosure = 0;
    private ArrayList<LycanthropeSolitary> listSolitary = new ArrayList<>();

    public void addLycanSolitary(LycanthropeSolitary lycan){
        listSolitary.add(lycan);
        nbEnclosure+=1;
        ID = nbEnclosure;
    }
    public int getID(){
        return ID;
    }
}
