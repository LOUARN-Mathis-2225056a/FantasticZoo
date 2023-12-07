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

    public void showPrincipalMenu(){
        ShowInTerminal.getInstance().showTitle("choose an action");
        System.out.println(
                """
                        To perform an action type the appropriated action number :
                            - 1 : check an enclosure to see what's inside get more information etc...
                            - 2 : clean an enclosure.
                            - 3 : feed the chosen enclosure.
                            - 4 : you will be redirected to the transfer menu."""
        );
    }
    public void transferFailed(){
        ShowInTerminal.getInstance().showTitle("error");
        System.out.println("The transfer has failed to occur !");
    }
    public void transferSucceeded(){
        System.out.println("The creature has been successfully transferred !");
    }
}
