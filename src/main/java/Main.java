import model.creature.*;
import model.enclosure.AbstractEnclosure;
import model.enclosure.Aquarium;
import model.enclosure.Aviary;
import model.enclosure.Enclosure;
import model.fantasticZoo.FantasticZoo;
import model.getOperatingSystem.GetOperatingSystem;
import model.zooMaster.ZooMaster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        if (GetOperatingSystem.getOperatingSystem().contains("Linux")) Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        else {
            System.out.println("Passez sous linux svp");
            System.exit(1);
        }
        // Pour avoir le résultat dans une autre fenetre
        // LINUX
//         Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        // Window
        /*
        Runtime.getRuntime().exec("cmd /c start cmd.exe");

        Dragon m1 = new Dragon("Mermaid", false, 10,10,10);
        System.out.println(Arrays.toString(m1.getClass().getInterfaces()));

        Nymph n1 = new Nymph("Michel", true, 100, 10, 1);*/
        FantasticZoo ft = new FantasticZoo();
        AbstractEnclosure aqua1 = new Aquarium();
        AbstractEnclosure avia1 = new Aviary();
        AbstractEnclosure enclo1 = new Enclosure();
        AbstractEnclosure avia2 = new Aviary();
        AbstractEnclosure avia3 = new Aviary();

        //Kraken kra1 = new Kraken("kra1",true,2,20,1);
        //Kraken kra2 = new Kraken("kra2",true,2,20,1);
        AbstractEnclosure aqua2 = new Aquarium();
        //aqua2.addCreature(kra1);
        //aqua2.addCreature(kra2);

        ft.addEnclosure(aqua1);
        ft.addEnclosure(avia1);
        ft.addEnclosure(enclo1);
        ft.addEnclosure(avia2);
        ft.addEnclosure(avia3);
        ft.addEnclosure(aqua2);

        ZooMaster zm = new ZooMaster("Léo",true,19,ft);
        Thread Tzm = new Thread(zm);
        Tzm.run();
    }
}