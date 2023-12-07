package td2.model.lycan;

import td2.model.roar.*;

public abstract class Lycanthrope2{
    private boolean sex; // true = female && false == mal
    public enum AgeCategory {
        YOUNG,
        ADULT,
        OLD,
    }
    private AgeCategory age;
    private int strength;
    private int domination; // corresponding to the difference between the domination exercised and those suffered
    private int level; // corresponding to the subjective quality criterion of a lycanthrope, both male and female; calculated based on age category, strength, dominance factor and rank
    private int impetuosity;
    private boolean sleep; // true = sleep / false = dont sleep
    private boolean sick; // true = sick / false = is not sick
    private Thread thread;
    private boolean isOn; // true tread run / false thread dont run

    // CONSTRUCTOR
    public Lycanthrope2(boolean sex, AgeCategory age, int strength, int domination, int impetuosity) {
        this.sex = sex;
        this.age = age;
        this.strength = strength;
        this.domination = domination;
        this.impetuosity = impetuosity;
        setLevel();
        sick = false;
        sleep = false;
        isOn = true;
    }

    // SETTER AND GETTER
    public boolean isOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }
    public Thread getThread() {
        return thread;
    }
    public void setThread(Thread thread) {
        this.thread = thread;
    }
    public void startThread(){
        thread.start();
    }
    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public AgeCategory getAge() {
        return age;
    }
    public void setAge(AgeCategory age) {
        this.age = age;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getDomination() {
        return domination;
    }
    public void setDomination(int domination) {
        this.domination = domination;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel() {
        level = 0;
        if (age == AgeCategory.YOUNG){
            level += 10;
        } else if (age == AgeCategory.ADULT) {
            level += 20;
        } else {
            level += 30;
        }
        level += strength;
        level += domination;
    }
    public void addIntLevel(int moreLevel){
        level += moreLevel;
    }
    public int getImpetuosity() {
        return impetuosity;
    }
    public void setImpetuosity(int impetuosity) {
        this.impetuosity = impetuosity;
    }

    // FUNCTION AND METHOD
    @Override
    public String toString() {
        return "\u001B[31m" + "Lycanthrope: " + "\u001B[0m" + "-sex : " + sex + "\n"
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
    public abstract void death();
    public void growOld(){
        if (age == AgeCategory.YOUNG){
            age = AgeCategory.ADULT;
        } else if (age == AgeCategory.ADULT) {
            age = AgeCategory.OLD;
        }else{
            death();
        }
    }
}
