package model.creature;

public class Mermaid extends Viviparous implements Swimmer{
    public Mermaid(String name, boolean sexe, float weight, float height, int hunger, boolean sleep, int health, int age) {
        super(name, sexe, weight, height, hunger, sleep, health, age);
    }

    @Override
    public void creatureSwim() {
        System.out.println(getName() + " is swimming !");
    }
}
