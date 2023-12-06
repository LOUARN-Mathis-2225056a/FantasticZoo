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
    public void addLycan(LycanthropeInPack lycan){listLycan.add(lycan);}
    public void removeLycan(LycanthropeInPack lycan){
        listLycan.remove(lycan);
    }

    public void setAlphaCouple(AlphaCouple alphaCouple) {
        this.alphaCouple = alphaCouple;
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
