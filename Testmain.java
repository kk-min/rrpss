import Classes.AMenuItem.MenuInterface;

public class Testmain {
    public static void main(String[] args){
        int exit = 1;
        MenuInterface.initiateMenu();
        do{
        //generateMenuScreen:exit code=-1
        exit = MenuInterface.generateMenuScreen();}
        while(exit != -1);

        



    }
    
}
