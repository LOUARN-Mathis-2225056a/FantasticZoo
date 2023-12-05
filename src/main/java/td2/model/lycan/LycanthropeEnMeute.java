package td2.model.lycan;

import td2.model.LycanPack;

public class LycanthropeEnMeute extends Lycanthrope2{
    private String rank;
    private LycanPack lycanPack;

    public LycanthropeEnMeute(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity,String rank,LycanPack lycanPack) {
        super(sex, age, strength, domination, level, impetuosity);
        this.rank = rank;
        this.lycanPack = lycanPack;
    }
    @Override
    public String toString(){
        return super.toString()
                + "             -rank : " + rank + "\n";
    }
}
