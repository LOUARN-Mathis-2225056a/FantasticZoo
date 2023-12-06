package td1.view;

public class ShowMessage {
    private static ShowMessage instance;

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

    public static ShowMessage getInstance() {
        if(instance == null){
            instance = new ShowMessage();
        }
        return instance;
    }
}
