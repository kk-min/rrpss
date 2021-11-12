package Classes.Order;
import java.util.Scanner;

public class OrderInterface {

    private static ArrayList<Order> OrderHistory;

    public OrderInterface() {
        OrderHistory = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderHistory() {
        return OrderHistory;
    }

    public static Order create(ArrayList<Staff> staffList) {
        System.out.print("Please enter the Table ID for the order: ");
        tableID = in.nextInt();
        Table.getTableById(tableID).setOccupied();
        System.out.print("Is the customer a member? (Y/N): ");
        isMember = in.nextChar();
        if (isMember == 'Y') isMember = true;
        else isMember = false;
        for (Staff staff : staffList){
            System.out.println(staff.getEmployeeID(), ": ", staff.getName());
        }
        System.out.print("Please enter your staff ID: ");
        staffID = in.nextInt();
        Order userOrder = new Order(tableID, staffID, isMember);
        System.out.println("You have created a new order. Order ID: %d\n", userOrder.getID());
        return userOrder;
    }

    public static void view() {
        int flag = 0;
        System.out.print("Please enter the Order ID to view: ");
        orderID = in.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                userOrder = viewOrder;
                flag = 1; // We found our Order
                break;
            }
        }
        if (flag == 0){
            System.out.println("Invalid Order ID.");
        }
        else{
            Printer.printInvoice(userOrder); // We can just print the invoice from the printer class, because that's basically the summary of the order...
        }
    }

    public static void add() {
        int flag = 0;
        System.out.print("Please enter the Order ID to add items to: ");
        orderID = in.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                userOrder = viewOrder;
                flag = 1; // We found our Order
                break;
            }
        }
        if (flag == 0){
            System.out.println("Invalid Order ID.");
        }
        else{
            flag = 0;
            System.out.println("You have chosen Order %d. Current items in this order:", userOrder.getID());
            itemList = userOrder.getitemList();
            for (int i = 0; i < itemList.length(); i++) {
                System.out.println("%d. %s", i+1, itemList[i].getName());
            }
            
            // Add Item
            // TODO: display menu items
            System.out.println("Please select an item to add to order: ");
            itemID = in.nextInt();  // TODO: convert into AMenuItem
            System.out.println("Enter the quantity: ");
            itemQty = in.nextInt();
            userOrder.addItem(itemID, itemQty);
        }
    }

    public static void remove() {
        int flag = 0;
        System.out.print("Please enter the Order ID to remove items from: ");
        orderID = in.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                userOrder = viewOrder;
                flag = 1; // We found our Order
                break;
            }
        }
        if (flag == 0){
            System.out.println("Invalid Order ID.");
        }
        else{
            System.out.println("You have chosen Order %d. Current items in this order:", userOrder.getID());
            itemList = userOrder.getitemList();
            for (int i = 0; i < itemList.length(); i++) {
                System.out.println("%d. %s", i+1, itemList[i].getName());
            }

            // Remove Item
            System.out.println("Please select the item you wish to remove: ");
            itemID = in.nextInt();  // TODO: convert to object
            userOrder.removeItem(itemID);
            System.out.println("Item successfully Removed.");
        }
    }

    public static void checkout() {
        System.out.print("Please enter the Order to checkout: ");
        orderID = in.nextInt();
        for (Order viewOrder : OrderHistory){
            if (viewOrder.getID() == orderID){
                userOrder = viewOrder;
                flag = 1; // We found our Order
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Invalid Order ID.");
        }
        else {
            Printer.printInvoice(userOrder);
            int tableID = userOrder.getTableID();
            Table.getTableById(tableID).setEmpty();
            System.out.println("Order successfully checked out.");
        }
    }
}
