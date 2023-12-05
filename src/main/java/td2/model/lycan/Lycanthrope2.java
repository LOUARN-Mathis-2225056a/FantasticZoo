package td2.model.lycan;

import td2.model.roar.*;

public class Lycanthrope2 {
    private boolean sex; // true = female && false == mal

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

    public Lycanthrope2(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity) {
        this.sex = sex;
        this.age = age;
        this.strength = strength;
        this.domination = domination;
        this.level = level;
        this.impetuosity = impetuosity;
    }

    @Override
    public String toString() {
        return "Lycanthrope: " + "-sex : " + sex + "\n"
                + "             -age : " + age + "\n"
                + "             -strength : " + strength + "\n"
                + "             -domination : " + domination + "\n"
                + "             -level : " + level + "\n"
                + "             -impetuosity : " + impetuosity + "\n";
    }
    public void ShowToString(){System.out.println(this.toString());}
    public void emitHowl(Roar roar){
        // je ne sais pas si je fait le comportement des émission
        if (roar.getClass() == Domination.class){
            System.out.println(roar.getWhatISay());
        } else if (roar.getClass() == Submission.class) {
            System.out.println(roar.getWhatISay());
        } else if (roar.getClass() == Aggressiveness.class) {
            System.out.println(roar.getWhatISay());
        } else if (roar.getClass() == Membership.class) {
            System.out.println(roar.getWhatISay());
        }
    }
}
