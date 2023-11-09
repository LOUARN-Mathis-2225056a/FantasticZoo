import model.creature.Dragon;
import model.creature.Mermaid;
import model.creature.Swimmer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dragon m1 = new Dragon("Mermaid", false, 10,10,10);
        System.out.println(Arrays.toString(m1.getClass().getInterfaces()));

    }

}
