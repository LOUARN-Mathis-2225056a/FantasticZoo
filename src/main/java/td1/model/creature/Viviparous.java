package td1.model.creature;

public abstract class Viviparous extends Creature{
    public Viviparous(String name, boolean sex, float weight, float height, int age){
        super(name,sex,weight,height,age);

    }

    public void giveBirth(){
    }
}
