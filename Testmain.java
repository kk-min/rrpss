public class Testmain {
    public static void main(String[] args){
        int exit = 1;
        Menumanager.initiateMenu();
        do{
        //generateMenuScreen:exit code=-1
        exit = Menumanager.generateMenuScreen();}
        while(exit != -1);

        



    }
    
}
