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
                        
                This game include 3 pre-made situations.
                - 1 : Only ground enclosures are made with ground creatures
                - 2 : Only aviary are made with flying creatures
                - 3 : Only aquarium ares made with sea creatures
                type 1, 2 or 3 to select the mode you want to play.
                
                Selected preset:
                """);
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
        text+=topAndBottomSide + "\n | " + title.toUpperCase() + " |\n" + topAndBottomSide;
        System.out.println(text);
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
