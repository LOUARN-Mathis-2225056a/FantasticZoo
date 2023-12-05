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
    private boolean sleep; // true = sleep / false = dont sleep
    private boolean sick; // true = sick / false = is not sick

    public Lycanthrope2(boolean sex, AgeCategory age, int strength, int domination, int level, int impetuosity) {
        this.sex = sex;
        this.age = age;
        this.strength = strength;
        this.domination = domination;
        this.level = level;
        this.impetuosity = impetuosity;
        sick = false;
        sleep = false;
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
        System.out.println(roar.getWhatISay());
    }
    public void receiveHowl(Roar roar){
        if (sleep == false && sick == false){
            if (roar.getClass() == Domination.class){
                if (this == ((Domination) roar).getSubmitted()){
                    emitHowl(new Submission());
                }
                else {
                    emitHowl(new Aggressiveness());
                }
            }else if (roar.getClass() == Membership.class && ((Membership) roar).isIAmTheFirst()) {
                this.emitHowl(new Membership());
            }
        }
    }
}
