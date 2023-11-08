package model.enclosure;

public class Aquarium extends Enclosure{
    private float depht;
    private int salinity;

    public Aquarium(float depht, int salinity){
        super();
        this.depht = depht;
        this.salinity = salinity;
    }

    @Override
    public void clean(){
        /*code*/
    }
}
