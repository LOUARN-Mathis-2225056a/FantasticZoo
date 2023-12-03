import model.creature.*;
import model.fantasticZoo.FantasticZoo;
import model.zooMaster.ZooMaster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        // Pour avoir le résultat dans une autre fenetre
        // LINUX
        // Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        // Window
        /*
        Runtime.getRuntime().exec("cmd /c start cmd.exe");

        Dragon m1 = new Dragon("Mermaid", false, 10,10,10);
        System.out.println(Arrays.toString(m1.getClass().getInterfaces()));

        Nymph n1 = new Nymph("Michel", true, 100, 10, 1);*/
        FantasticZoo ft = new FantasticZoo();
        ZooMaster zm = new ZooMaster("Léo",true,19,ft);
        Thread Tzm = new Thread(zm);
        Tzm.run();
    }
}