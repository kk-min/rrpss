package Classes.Printer;

import Classes.Order.OrderManager;
import java.util.InputMismatchException;

/**
 * The OrderSubMenu Class
 * Implements printing functinality for Order sub-menus
 * extends UserInterfacePrinter
 * @author  Her Huey
 * @author  Min
 * @version 2.0
 * @since   2021-11-12
 */
public class OrderSubMenu extends UserInterfacePrinter {
    /**
     * Prints the order submenu and calls the respective OrderManager methods based on the user's choice
     * @return an integer flag indicating whether to exit the the application
     */
    public static int print(){
        while (true) {
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            System.out.println("Order\nSelect an option:\n" );
            System.out.println("1) Create a new order");
            System.out.println("2) View an existing order");
            System.out.println("3) Add item to an existing order");
            System.out.println("4) Remove item from an existing order");
            System.out.println("5) Checkout an order / Print Order Invoice");
            System.out.println("6) Back to main menu");
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
                case 1:
                    OrderManager.create();
                    break;
                case 2:
                    OrderManager.view();
                    break;
                case 3:
                    OrderManager.add();
                    break;
                case 4:
                    OrderManager.remove();
                    break;
                case 5:
                    OrderManager.checkout();
                    break;
                case 6:
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
