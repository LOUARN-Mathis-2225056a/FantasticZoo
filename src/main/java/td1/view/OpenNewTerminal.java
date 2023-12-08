package td1.view;

import td1.model.getOperatingSystem.GetOperatingSystem;

import java.io.IOException;

public class OpenNewTerminal {

    /**
     * Opens a new terminal with the logs
     */
    public static void execute() throws IOException {
        if (GetOperatingSystem.getOperatingSystem().contains("Linux"))
            Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e tail -F logs");
        else Runtime.getRuntime().exec("cmd /C Get-Content log -Wait ");
    }
}
