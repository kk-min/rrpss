package Classes.Printer;

/**
 * Implements printing functinality for Menu sub-menus
 */
public class MenuSubMenu extends UserInterfacePrinter {
    /**
     * Prints the menu submenu
     * @return an integer flag indicating whether to exit the the application or go to previous menu
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
            int choice = input.nextInt();
        
            switch (choice) {
                case 1: // Prints menu
                    Classes.AMenuItem.MenuManager.displayMenu();
                    break;
                case 2: // Create new menu item
                    Classes.AMenuItem.MenuManager.addAlaCarteItem();
                    break;
                case 3: // Edit an existing menu item
                    Classes.AMenuItem.MenuManager.updateAlaCarteItem();
                    break;
                case 4: // Delete an existing menu item
                    Classes.AMenuItem.MenuManager.deleteAlaCarteItem();
                    break;
                case 5: // Create a new promo item
                    Classes.AMenuItem.MenuManager.addPromoItem();
                    break;
                case 6: // Edit an existing promo item's details
                    Classes.AMenuItem.MenuManager.updatePromoItem();
                    break;
                case 7: // Delete a promo item"
                    Classes.AMenuItem.MenuManager.deletePromoItem();
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
