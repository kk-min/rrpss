package Classes.Order;

import java.util.Scanner;
import java.util.ArrayList;

import Classes.Printer.PrintReceipt;
import Classes.AMenuItem.AMenuItem;
import Classes.AMenuItem.MenuManager;
import Classes.Staff.Staff;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;

public class OrderManager {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Order> OrderHistory;

    public OrderManager() {
        OrderHistory = new ArrayList<Order>();
    }

    public static ArrayList<Order> getOrderHistory() {
        return OrderHistory;
    }

    public static Order create() {
        System.out.print("Please enter the Table ID for the order: ");
        int tableID = input.nextInt();
        TableManager.getTableByID(tableID).setOccupied();
        System.out.print("Is the customer a member? (Y/N): ");
        char member = input.next().charAt(0);
        boolean isMember = false;
        if (member == 'Y') isMember = true;
        Staff staff = StaffManager.getStaff();
        Order userOrder = new Order(tableID, staff, isMember);
        System.out.printf("You have created a new order with ID-%d %n", userOrder.getID());
        return userOrder;
    }

    public static void view() {
        System.out.print("Please enter the Order ID to view: ");
        int orderID = input.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                PrintReceipt.printInvoice(viewOrder); // We can just print the invoice from the printer class, because that's basically the summary of the order...
                return;
            }
        }
        System.out.println("Invalid Order ID.");
    }

    public static void add() {
        System.out.print("Please enter the Order ID to add items to: ");
        int orderID = input.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                Order userOrder = viewOrder;
                System.out.printf("You have chosen Order %-9d. Current order summary: %n", userOrder.getID());
                PrintReceipt.printInvoice(userOrder);
                
                // Add Item
                AMenuItem newItem = MenuManager.getMenuItem();
                System.out.println("Enter the quantity: ");
                int itemQty = input.nextInt();
                userOrder.addItem(newItem, itemQty);

                return;
            }
        }

        System.out.println("Invalid Order ID.");
    }

    public static void remove() {
        System.out.print("Please enter the Order ID to remove items from: ");
        int orderID = input.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                Order userOrder = viewOrder;
                System.out.printf("You have chosen Order %-9d. Current order summary: %n", userOrder.getID());
                PrintReceipt.printInvoice(userOrder);

                // Remove Item
                AMenuItem item = MenuManager.getMenuItem();
                System.out.println("Enter the quantity: ");
                int itemQty = input.nextInt();
                userOrder.removeItem(item, itemQty);

                return;
            }
        }

        System.out.println("Invalid Order ID.");
    }

    public static void checkout() {
        System.out.print("Please enter the Order to checkout: ");
        int orderID = input.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                Order userOrder = viewOrder;
                PrintReceipt.printInvoice(userOrder);
                int tableID = userOrder.getTableID();
                TableManager.getTableByID(tableID).setEmpty();
                System.out.println("Order successfully checked out.");
                return;
            }
        }
        System.out.println("Invalid Order ID.");
    }
}
