import td1.creature.Phoenix;
import td1.enclosure.AbstractEnclosure;
import td1.enclosure.Aquarium;
import td1.enclosure.Aviary;
import td1.enclosure.Enclosure;
import td1.fantasticZoo.FantasticZoo;
import td1.getOperatingSystem.GetOperatingSystem;
import td1.zooMaster.ZooMaster;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (GetOperatingSystem.getOperatingSystem().contains("Linux")) Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        else {
            System.out.println("Passez sous linux svp");
            //Runtime.getRuntime().exec("powershell");
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
        Aviary v1 = new Aviary();

        Phoenix p1 = new Phoenix("Michel", false, 10, 10, 1);
        v1.addCreature(p1);

        ZooMaster zm = new ZooMaster("Léo",true,19,ft);
        Thread Tzm = new Thread(zm);
        Tzm.run();
    }
}