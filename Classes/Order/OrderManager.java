package Classes.Order;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Classes.Printer.PrintOrderSummary;
import Classes.Printer.PrintReceipt;
import Classes.Reservation.ReservationManager;
import Classes.AMenuItem.AMenuItem;
import Classes.AMenuItem.MenuManager;
import Classes.Staff.Staff;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;
import Classes.Time.DateTimeFormatHelper;

public class OrderManager {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Order> OrderHistory;

    public OrderManager() {
        OrderHistory = new ArrayList<Order>();
    }

    public static ArrayList<Order> getOrderHistory() {
        return OrderHistory;
    }

    public static void create() {
        System.out.print("Enter customer's reservation ID (enter -1 if this is a walk-in): ");
        int resvID = input.nextInt();
        int tableID, numPax;
        LocalDate currentDate = DateTimeFormatHelper.inbuiltDate();
        LocalTime currentTime = DateTimeFormatHelper.inbuiltTime();
        char currentSession = ' ';

        // assign customer to a table
        if (resvID == -1) {
            // walk in
            numPax = 0;
            while (numPax <= 0 || numPax > 10) {
				System.out.print("Enter number of pax: ");
				numPax = input.nextInt();
				if (numPax <= 0) {
					System.out.println("You have cannot have less than 1 person.");
				} else if (numPax > 10) {
					System.out.println("Sorry! The restaurant's maximum seating is 10 people.");
				}
			}
            if (DateTimeFormatHelper.checkResvTimeSession(currentTime, LocalTime.of(10, 0), LocalTime.of(16, 0))) {
                    currentSession = 'A';
                }
            else if (DateTimeFormatHelper.checkResvTimeSession(currentTime, LocalTime.of(18, 0),
                    LocalTime.of(23, 59))) {
                currentSession = 'P';
            }
			tableID = ReservationManager.findTableForReservation(numPax, currentDate, currentSession);
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

    public static void view() {
        System.out.print("Please enter the Order ID to view: ");
        int orderID = input.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                PrintOrderSummary.print(viewOrder);
                return;
            }
        }
        System.out.println("Invalid Order ID.");
    }

    public static void add() {
        System.out.print("Please enter the Order ID to add items to: ");
        int orderID = input.nextInt();
        for (Order userOrder : OrderHistory){
            if (userOrder.getID() == orderID){
                System.out.printf("You have chosen Order %-9d. Current order summary: %n", userOrder.getID());
                PrintOrderSummary.print(userOrder);
                
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
        for (Order userOrder : OrderHistory){
            if (userOrder.getID() == orderID){
                System.out.printf("You have chosen Order %-9d. Current order summary: %n", userOrder.getID());
                PrintOrderSummary.print(userOrder);

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
