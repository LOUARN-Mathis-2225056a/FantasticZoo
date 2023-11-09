package model.creature;

public class Creature {
    private String name;
    private boolean sexe;
    private float weight;
    private float height;
    private int hunger = 100;
    private boolean sleep = false;
    private int health = 100;
    private int age = 0;

    /* CONSTRUCTOR */
    public Creature(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        this.name = name;
        this.sexe = sexe;
        this.weight = weight;
        this.height = height;
        this.hunger = hunger;
        this.sleep = sleep;
        this.health = health;
        this.age = age;
    }

    /* SETTER */
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /* GETTER */

    public String getName(){return name;}
    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public int getHunger() {
        return hunger;
    }

    public boolean isSleep() {
        return sleep;
    }

    public int getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }

    /* METHOD */
    public void eat(){
        if (hunger<=90){
            hunger += 10;
            System.out.println(name + "'s hunger is at " + hunger);
        }
        else{
            System.out.println(name + " is not hungry.");
        }
    }

    public void emitSound(){
        System.out.println("???");
    }
    public void heal(){
        if (health<=90){
            health += 10;
            System.out.println(name + "'s health is now at  " + health);
        }
        else{
            System.out.println(name + " is already healthy.");
        }
    }

    public void wake(){
        if(sleep){
            sleep = false;
            System.out.println(name + " wake up.");
        }
        else{
            System.out.println(name + " is already sleeping.");
        }
    }

    public void sleep(){
        if(!sleep){
            sleep = true;
            System.out.println(name + " falls asleep.");
        }
        else{
            System.out.println(name + " is already asleep.");
        }
    }
}

