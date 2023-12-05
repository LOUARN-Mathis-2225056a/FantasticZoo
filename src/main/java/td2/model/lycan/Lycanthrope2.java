package td2.model.lycan;

public class Lycanthrope2 {
    private boolean sex;

    public enum AgeCategory {
        YOUNG,
        ADULT,
        OLD;
    }
    private AgeCategory age;
    private int strength;
    private int domination; // corresponding to the difference between the domination exercised and those suffered
    private int level; // corresponding to the subjective quality criterion of a lycanthrope, both male and female; calculated based on age category, strength, dominance factor and rank
    private int impetuosity;
}
