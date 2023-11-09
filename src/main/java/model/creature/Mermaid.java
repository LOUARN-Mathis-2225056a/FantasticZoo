package model.creature;

public class Mermaid extends Viviparous implements Swimmer{
    public Mermaid(String name, boolean sexe, float weight, float height, int age){
        super(name,sexe,weight,height,age);
    }

    @Override
    public String creatureSwim() {
        return (getName() + " is swimming !");
    }
}
