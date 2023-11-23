import model.creature.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Pour avoir le résultat dans une autre fenetre

        Dragon m1 = new Dragon("Mermaid", false, 10,10,10);
        System.out.println(Arrays.toString(m1.getClass().getInterfaces()));

        Nymph n1 = new Nymph("Michel", true, 100, 10, 1);
    }
}