package Classes.Printer;

import Classes.Order.OrderManager;

/**
 * Implements printing functionality for Order sub-menus
 * @version 1.0
 */
public class OrderSubMenu extends UserInterfacePrinter {
    /**
     * Prints the order sub-menu
     * @return an integer flag indicating whether to exit the the application or go to previous menu
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
            int choice = input.nextInt(); input.nextLine();
        
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
