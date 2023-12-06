package td1.view;

import td1.model.enclosure.AbstractEnclosure;

public class ShowInTerminal {
    private static ShowInTerminal instance;

    public void showWelcomeMessage(){
        System.out.print(
                """
                                 _    _      _                        \s
                                | |  | |    | |                       \s
                                | |  | |   ___| | ___ ___  _ __ ___   ___
                                | |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\
                                \\  /\\  /  __/ | (_| (_) | | | | | |  __/
                                 \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|
                        
                This game include 3 premades situations.
                - 1 : Only ground enclosures are made with ground creatures
                - 2 : Only aviary are made with flying creatures
                - 3 : Only aqurium ares made with sea creatures
                type 1, 2 or 3 to select the mode you want to play.
                /!\\ you can I any case add new enclosure types.
                
                Selected preset:
                """);
    }

    public void showTitle(String title){
        String text = "";
        String topAndBottomSide = "";
        for (int i = 0; i < title.length()+2; i++) {
            topAndBottomSide+="-";
        }
        text+=topAndBottomSide + "\n | " + title.toUpperCase() + " |\n" + topAndBottomSide;
        System.out.println(text);
    }

    public void showEnclosure(AbstractEnclosure<?> enclosure, int enclosureNumber){
        String topAndBottomSide = "";
        switch ((String) enclosure.getType()){
            case "Runner" -> topAndBottomSide = "--------------- ";
            case "Swimmer" -> topAndBottomSide = "~~~~~~~~~~~~~~ ";
            case "Flyer" -> topAndBottomSide = "ooooooooooooooo ";
        }
        String text = "" + topAndBottomSide;
        String blankLine = "|           |\n";
        if(enclosureNumber>=10){
            String numberLine = "|     "+enclosureNumber+"    |\n";
        }
        String numberLine = "|     "+enclosureNumber+"     |\n";
        text+= blankLine + blankLine + numberLine + blankLine + blankLine + topAndBottomSide;
        System.out.println(text);
    }

    public static ShowInTerminal getInstance() {
        if(instance == null){
            instance = new ShowInTerminal();
        }
        return instance;
    }
}
