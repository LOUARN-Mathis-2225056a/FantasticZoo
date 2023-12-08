package td2.model;

import td2.model.lycan.LycanthropeInPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LycanPack {
    private ArrayList<LycanthropeInPack> listLycan;
    private AlphaCouple alphaCouple;
    private Enclosure2 enclosure;

    /* CONSTRUCTOR */
    public LycanPack(Enclosure2 enclosure) {
        listLycan = new ArrayList<LycanthropeInPack>();
        this.enclosure = enclosure;
        alphaCouple = new AlphaCouple(null,null);
    }

    /* GETTER AND SETTER */

    public ArrayList<LycanthropeInPack> getListLycan() {
        //sortListLycan();
        return listLycan;
    }

    public AlphaCouple getAlphaCouple() {
        return alphaCouple;
    }

    public Enclosure2 getEnclosure() {
        return enclosure;
    }
    public void setAlphaCouple(AlphaCouple alphaCouple) {
        this.alphaCouple = alphaCouple;
    }

    /* METHOD AND FUNCTION */
    public void sortListLycan(){
        Collections.sort(listLycan, Comparator.comparingInt(LycanthropeInPack::getRank));
    }
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
        String result = new String("\u001B[34m"+ "LYCAN PACK : \n" + "\u001B[0m"
                + "\u001B[32m" + "- " + enclosure + "\n"
                + "\u001B[32m" + "- " + alphaCouple + "\n"
                +"\u001B[32m"+ "- ALL LYCAN : \n" + "\u001B[0m");
        sortListLycan();
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            result += lycanthropeInPack + "\n";
        }
        return result;
    }
    public void showToString(){System.out.println(this);}
    public boolean hasLowerRank(int rankOfTheLycan){
        sortListLycan();
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            if (lycanthropeInPack.getRank()>rankOfTheLycan && lycanthropeInPack.getRank() != 24){
                return true;
            }
        }
        return false;
    }
    public void setBestFemale(){
        LycanthropeInPack bestFemale = null;
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            if (lycanthropeInPack.isSex() && (bestFemale == null || bestFemale.getLevel()<lycanthropeInPack.getLevel())){
                bestFemale = lycanthropeInPack;
            }
        }
        alphaCouple.setFemale(bestFemale);
        System.out.println("\u001B[32m"
                + "                                                                      A new couple has been designated in the enclosure "
                + enclosure.getID()
                + "\u001B[0m" );
    }
    public void setBestMale(){
        LycanthropeInPack bestMale = null;
        for (LycanthropeInPack lycanthropeInPack : listLycan){
            if (!lycanthropeInPack.isSex() && (bestMale == null || bestMale.getLevel()<lycanthropeInPack.getLevel())){
                bestMale = lycanthropeInPack;
            }
        }
        alphaCouple.setMale(bestMale);
        System.out.println("\u001B[32m"
                + "                                                                      A new couple has been designated in the enclosure "
                + enclosure.getID()
                + "\u001B[0m" );
    }
}
