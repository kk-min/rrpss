import Classes.AMenuItem.MenuManager;

public class Testmain {
    public static void main(String[] args){
        int exit = 1;
        MenuManager.initiateMenu();
        do{
        //generateMenuScreen:exit code=-1
        exit = MenuManager.generateMenuScreen();}
        while(exit != -1);

        



    }
    
}
