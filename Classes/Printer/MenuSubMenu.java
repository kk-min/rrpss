package Classes.Printer;

import Classes.AMenuItem.MenuManager;
import java.util.InputMismatchException;

/**
 * The MenuSubMenu Class
 * Implements printing functinality for Menu sub-menus
 * extends UserInterfacePrinter
 * @author  Lingyi
 * @author  Her Huey
 * @author  Min
 * @version 2.0
 * @since   2021-11-12
 */
public class MenuSubMenu extends UserInterfacePrinter {
    /**
     * Prints the menu submenu and calls the respective MenuManager methods based on the user's choice
     * @return an integer flag indicating whether to exit the the application
     */
    public static int print(){
        while (true) {

            System.out.printf("-".repeat(rowLength));
            System.out.println();
            System.out.println("Restaurant Menu\nSelect an option:\n" );
            System.out.println("1) View Menu");
            System.out.println("2) Create a new A la Carte item");
            System.out.println("3) Update an existing A la Carte item's details");
            System.out.println("4) Delete an existing A la Carte item");
            System.out.println("5) Create a new Promotional item");
            System.out.println("6) Update an existing Promotional item's details");
            System.out.println("7) Delete an existing Promotional item");
            System.out.println("8) Back to main menu");
            System.out.println("0) Exit Application");
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            int choice = 0;
            boolean validChoice = false;
            while(!validChoice){
                try{
                    choice = input.nextInt(); input.nextLine();
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter a valid entry.");
                    input.nextLine();
                }
                validChoice = true;
            }
        
            switch (choice) {
                case 1: // Prints menu
                    MenuManager.displayMenu();
                    break;
                case 2: // Create new menu item
                    MenuManager.addAlaCarteItem();
                    break;
                case 3: // Edit an existing menu item
                    MenuManager.updateAlaCarteItem();
                    break;
                case 4: // Delete an existing menu item
                    MenuManager.deleteAlaCarteItem();
                    break;
                case 5: // Create a new promo item
                    MenuManager.addPromoItem();
                    break;
                case 6: // Edit an existing promo item's details
                    MenuManager.updatePromoItem();
                    break;
                case 7: // Delete a promo item"
                    MenuManager.deletePromoItem();
                    break;
                case 8:
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
