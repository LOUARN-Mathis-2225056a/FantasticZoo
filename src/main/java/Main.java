import model.creature.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        // Pour avoir le résultat dans une autre fenetre
        Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -f logs");

        Dragon m1 = new Dragon("Mermaid", false, 10,10,10);
        System.out.println(Arrays.toString(m1.getClass().getInterfaces()));

        Nymph n1 = new Nymph("Michel", true, 100, 10, 1);
    }
}