import td1.model.creature.Phoenix;
import td1.model.enclosure.Aviary;
import td1.model.fantasticZoo.FantasticZoo;
import td1.model.getOperatingSystem.GetOperatingSystem;
import td1.model.zooMaster.ZooMaster;

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
    }
}