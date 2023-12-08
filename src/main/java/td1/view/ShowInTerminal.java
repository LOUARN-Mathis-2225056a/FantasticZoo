package td1.view;

import td1.model.enclosure.AbstractEnclosure;
import td1.model.enclosure.Aquarium;
import td1.model.enclosure.Aviary;
import td1.model.fantasticZoo.FantasticZoo;

public class ShowInTerminal {
    private static ShowInTerminal instance;

    /**
     * Shows a welcome message
     */
    public void showWelcomeMessage(){
        System.out.print(
                """
                                         _    _      _                        \s
                                        | |  | |    | |                       \s
                                        | |  | | ___| | ___ ___  _ __ ___   ___
                                        | |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\
                                        \\  /\\  /  __/ | (_| (_) | | | | | |  __/
                                         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|
                                
                        This game include 3 premades situations.
                        \u001B[32m- 1 : Only ground enclosures are made with ground creatures
                        \u001B[37m- 2 : Only aviary are made with flying creatures
                        \u001B[34m- 3 : Only aqurium ares made with sea creatures\u001B[0m
                        
                        type 1, 2 or 3 to select the mode you want to play.
                                        
                        \u001B[33m Selected preset :\u001B[0m""");
    }

    /**
     * Shows the title of the zoo
     *
     * @param title the title to show
     */
    public void showTitle(String title){
        String text = "";
        String topAndBottomSide = "";
        for (int i = 0; i < title.length()+2; i++) {
            topAndBottomSide+="-";
        }
        text+=topAndBottomSide + "\n|" + title.toUpperCase() + "|\n" + topAndBottomSide;
        System.out.println(text);
    }
    public void refreshTerminal(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    /**
     * Get the instance of the class
     *
     * @return the instance
     */
    public static ShowInTerminal getInstance() {
        if(instance == null){
            instance = new ShowInTerminal();
        }
        return instance;
    }
}
