package Classes.Order;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import Classes.Printer.PrintOrderSummary;
import Classes.Printer.PrintReceipt;
import Classes.Reservation.ReservationManager;
import Classes.AMenuItem.AMenuItem;
import Classes.AMenuItem.MenuManager;
import Classes.Staff.Staff;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;

/**
 * The OrderManager Class
 * Manages various functionalities pertaining to Order objects.
 * @author  Her Huey
 * @author  Min
 * @version 2.0
 * @since   2021-11-12
 */
public class OrderManager {
    /**
     * Scanner object for taking in user input
     */
    private static Scanner input = new Scanner(System.in);
    /**
    * ArrayList OrderHistor to store all Order Objects
    */
    private static ArrayList<Order> OrderHistory = new ArrayList<Order>();

    /**
     * Accessor for the order history (list of all orders made).
     * @return the order history
     */
    public static ArrayList<Order> getOrderHistory() {
        return OrderHistory;
    }

    /**
     * Assigns customer to a table and creates a new order for them.
     */
    public static void create() {
        System.out.print("Enter customer's reservation ID (enter -1 if this is a walk-in): ");
        int resvID = input.nextInt(); input.nextLine();
        int tableID, numPax;

        // assign customer to a table
        if (resvID == -1) {
            // walk in
            numPax = 0;
            while (numPax <= 0 || numPax > 10) {
				System.out.print("Enter number of pax: ");
				numPax = input.nextInt(); input.nextLine();
				if (numPax <= 0) {
					System.out.println("You have cannot have less than 1 person.");
				} else if (numPax > 10) {
					System.out.println("Sorry! The restaurant's maximum seating is 10 people.");
				}
			}
			tableID = TableManager.findTableForWalkIn(numPax);
            if (tableID == -1) {
				System.out.println(
					"There are no available tables that can cater the number of pax for now. We're sorry!");
                return;
			}
        }
        else { // reservation
            tableID = ReservationManager.getTableIDByReservationID(resvID);
        }

        TableManager.getTableByID(tableID).setOccupied();
        System.out.print("Is the customer a member? (Y/N): ");
        char member = input.next().charAt(0);
        boolean isMember = false;
        if (member == 'Y') isMember = true;
        Staff staff = StaffManager.getStaff();
        Order newOrder = new Order(tableID, staff, isMember);
        OrderHistory.add(newOrder);
        System.out.printf("You have created a new order with ID-%d %n", newOrder.getID());
    }

    /**
     * Views an Order based on Order ID by printing its Order Summary.
     */
    public static void view() {
        System.out.print("Please enter the Order ID to view: ");
        int orderID = input.nextInt(); input.nextLine();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                PrintOrderSummary.print(viewOrder);
                return;
            }
        }
        System.out.println("Invalid Order ID.");
    }

    /**
     * Adds a AMenuItem with specified quantity to an existing Order.
     */
    public static void add() {
        System.out.print("Please enter the Order ID to add items to: ");
        int orderID = input.nextInt(); input.nextLine();
        for (Order userOrder : OrderHistory){
            if (userOrder.getID() == orderID){
                System.out.printf("Current summary for Order %-9d is shown below.%n", userOrder.getID());
                PrintOrderSummary.print(userOrder);
                
                // Add Item
                AMenuItem newItem = MenuManager.getMenuItem();
                System.out.println("Enter the quantity: ");
                int itemQty = input.nextInt(); input.nextLine();
                userOrder.addItem(newItem, itemQty);
                return;
            }
        }

        System.out.println("Invalid Order ID.");
    }

    /**
     * Removes a MenuItem with specified quantity from an existing Order.
     */
    public static void remove() {
        System.out.print("Please enter the Order ID to remove items from: ");
        int orderID = input.nextInt(); input.nextLine();
        for (Order userOrder : OrderHistory){
            if (userOrder.getID() == orderID){
                System.out.printf("Shown below is the current summary for Order %-9d %n", userOrder.getID());
                PrintOrderSummary.print(userOrder);

                // Remove Item
                System.out.println("Choose item to remove from this order:");
                Set<AMenuItem> itemsSet = userOrder.getItemList().keySet();
                List<AMenuItem> items = new ArrayList<AMenuItem>(itemsSet);
                for (int i = 0; i < items.size(); i++) {
                    System.out.printf("%-2d - %-50s x%-2d\n", i+1, items.get(i).getName(), userOrder.getItemList().get(items.get(i)));
                }
                System.out.print("Item number to remove: ");
                int itemIndex = input.nextInt(); input.nextLine();
                System.out.print("Enter the quantity: ");
                int itemQty = input.nextInt(); input.nextLine();
                userOrder.removeItem(items.get(itemIndex-1), itemQty);

                return;
            }
        }

        System.out.println("Invalid Order ID.");
    }

    /**
     * Checks out an Order and prints its Receipt.
     * Customer to make payment and leave.
     */
    public static void checkout() {
        System.out.print("Please enter the Order to checkout: ");
        int orderID = input.nextInt(); input.nextLine();
        for (Order userOrder : OrderHistory){
            if (userOrder.getID() == orderID){
                PrintReceipt.print(userOrder);
                int tableID = userOrder.getTableID();
                TableManager.getTableByID(tableID).setEmpty();
                System.out.println("Order successfully checked out.");
                return;
            }
        }
        System.out.println("Invalid Order ID.");
    }
}
