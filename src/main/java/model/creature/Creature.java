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

    public void eat(){
        if (hunger<=90){
            hunger += 10;
            System.out.println("The animal's hunger is at " + hunger);
        }
        else{
            System.out.println("This animal is not hungry.");
        }
    }

    public void emitSound(){
        System.out.println("???");
    }
    public void heal(){
        if (health<=90){
            health += 10;
            System.out.println("The animal's health is now at  " + health);
        }
        else{
            System.out.println("This animal is already healthy.");
        }
    }

    public void wake(){
        if(sleep){
            sleep = false;
            System.out.println("This animal wake up.");
        }
        else{
            System.out.println("This animal is already sleeping.");
        }
    }

    public void sleep(){
        if(!sleep){
            sleep = true;
            System.out.println("this animal falls asleep.");
        }
        else{
            System.out.println("This animal is already asleep.");
        }
    }

    public void gettingOld(){
        // see
    }
}

