package Printer;
import Classes.Printer.UserInterfacePrinter;
public class OrderSubMenu extends UserInterfacePrinter {
    public static int print(){
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        System.out.println("Order\nSelect an option:\n" );
        System.out.println("1) Create a new order");
        System.out.println("2) View an existing order");
        System.out.println("3) Add item to an existing order");
        System.out.println("4) Remove item from an existing order");
        System.out.println("5) Back to main menu");
        System.out.println("0) Exit Application");
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        int choice = input.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    Classes.Order.OrderManager.create();
                    break;
                case 2:
                    Classes.Order.OrderManager.view();
                    break;
                case 3:
                    Classes.Order.OrderManager.add();
                    break;
                case 4:
                    Classes.Order.OrderManager.remove();
                    break;
                case 5:
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
