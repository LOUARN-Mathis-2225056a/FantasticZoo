package td1.view;

import td1.controller.ZooMasterController;

public class ZooMasterView {
    private static ZooMasterView instance;
    public static ZooMasterView getInstance() {
        if(instance == null){
            instance = new ZooMasterView();
        }
        return instance;
    }

    /**
     * Shows the principal menu with all the choices
     */
    public void showPrincipalMenu(){
        System.out.print(ColorInTerminal.TEXT_YELLOW);
        ShowInTerminal.getInstance().showTitle("choose an action");
        System.out.print(ColorInTerminal.TEXT_RESET);
        System.out.println(
                """
                        To perform an action type the appropriated action number :
                        \u001B[33m    - 1 : check an enclosure to see what's inside get more information etc...
                        \u001B[36m    - 2 : clean an enclosure.
                        \u001B[32m    - 3 : feed the chosen enclosure.
                        \u001B[37m    - 4 : you will be redirected to the transfer menu.
                        \u001B[31m    - 5 : you will leave the game......\u001B[0m"""
        );
    }

    /**
     * Runs if the transfer has failed
     */
    public void transferFailed(){
        ShowInTerminal.getInstance().showTitle(ColorInTerminal.TEXT_RED + "error");
        System.out.println("The transfer has failed to occur !" + ColorInTerminal.TEXT_RESET);

    }

    /**
     * Runs if the transfer has succeeded
     */
    public void transferSucceeded(){
        System.out.println(ColorInTerminal.TEXT_GREEN + "The creature has been successfully transferred !" + ColorInTerminal.TEXT_RESET);
    }

    public void goodbye(){
        ShowInTerminal.getInstance().refreshTerminal();
        ShowInTerminal.getInstance().showTitle("Goodbye !");
    }
}
