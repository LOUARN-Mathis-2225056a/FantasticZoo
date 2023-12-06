package td2.model;

import td2.model.lycan.LycanthropeInPack;

import java.util.ArrayList;

public class LycanPack {
    private ArrayList<LycanthropeInPack> listLycan = new ArrayList<LycanthropeInPack>();
    private AlphaCouple alphaCouple;
    private Enclosure2 enclosure;

    /* CONSTRUCTOR */
    public LycanPack(Enclosure2 enclosure) {
        this.enclosure = enclosure;
    }

    /* GETTER AND SETTER */
    public Enclosure2 getEnclosure() {
        return enclosure;
    }
    public void setAlphaCouple(AlphaCouple alphaCouple) {
        this.alphaCouple = alphaCouple;
    }

    /* METHOD AND FUNCTION */
    public void addLycan(LycanthropeInPack lycan){listLycan.add(lycan);}
    public void removeLycan(LycanthropeInPack lycan){
        listLycan.remove(lycan);
    }
    public boolean haveBeta(){
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            if (lycanthropeInPack.getRank() == 2){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String result = new String("LYCAN PACK : \n"
                + "- " + enclosure + "\n"
                + "- " + alphaCouple + "\n"
                + "- ALL LYCAN : \n");
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            result += "   - " + lycanthropeInPack + "\n";
        }
        return result;
    }
    public void showToString(){System.out.println(this);}
}
