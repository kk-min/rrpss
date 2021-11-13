package Classes.Printer;

import java.util.Scanner;

import Classes.AMenuItem.MenuManager;
import Classes.AMenuItem.AMenuItem;
import Classes.Order.OrderManager;
import Classes.Order.Order;
import Classes.Reservation.ReservationManager;
import java.util.Map;

public class SubMenuPrinter {

    private static Scanner input = new Scanner(System.in);

    // TODO Min: the line formatting for all 3 submenus here

    public static int printMenuSubMenu() {
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

		int choice = input.nextInt();
        while (true) {
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

    public static int printOrderSubMenu() {
		System.out.println("Order\nSelect an option:\n" );
        System.out.println("1) Create a new order");
        System.out.println("2) View an existing order");
        System.out.println("3) Add item to an existing order");
        System.out.println("4) Remove item from an existing order");
        System.out.println("5) Back to main menu");
		System.out.println("0) Exit Application");

		int choice = input.nextInt();
        while (true) {
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
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }

    public static void printOrderSummary(Order viewOrder){
        int rowLength = 63;

        //Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 2:
        String orderSummary = "ORDER SUMMARY";
        String leftFormat = "%-"+((rowLength/2)-(orderSummary.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(orderSummary.length()/2))+"s";
        System.out.format(leftFormat, " ");
        System.out.print(orderSummary);
        System.out.format(rightFormat, " ");
        System.out.println();

        //Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 4:
        String OrderNo = "Order no. "+viewOrder.getID();
        System.out.println(OrderNo);

        //Line 5:
        String tableFormat = String.format("%"+(OrderNo.length()-8)+"s");
        System.out.print("Table ID");
        System.out.format(tableFormat, viewOrder.getTableID());

        //Line 6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Items:
        for (var entry : viewOrder.getItemList().entrySet()){
            AMenuItem item = entry.getKey();
            String itemName = item.getName();
            String leftString = itemName+" x"+entry.getValue();
            System.out.print(leftString);
            String priceFormat = "%"+(rowLength-leftString.length())+"s";
            String priceString = "      $"+String.format("%.2f",item.getPrice()*entry.getValue())+"      ";
            System.out.format(priceFormat, priceString);
            System.out.println();
        }
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        double subTotal = viewOrder.getSubTotal();
        double grandTotal = viewOrder.getGrandTotal();
        //Bottom segment:
        String subTotalPrice = "$"+String.format("%.2f",subTotal);
        String totalPrice = "$"+String.format("%.2f",grandTotal);
        String discountRate = Integer.toString((int)(100*viewOrder.getDISCOUNT_RATE())) + "%";
        String taxRate = Integer.toString((int)(100*viewOrder.getTAX_RATE())) + "%";

        String discountFormat = String.format("%"+totalPrice.length()+"s", discountRate);
        String subTotalFormat = String.format("%"+totalPrice.length()+"s", subTotalPrice);
        String totalFormat = String.format("%"+totalPrice.length()+"s", totalPrice);
        String taxFormat = String.format("%"+totalPrice.length()+"s", taxRate);

        String subTotalString = "subTotal: "+subTotalFormat+"     ";
        String discountString = "Discount: "+discountFormat+"     ";
        String taxString = "Tax:      "+taxFormat+"     ";
        String totalString = "Total:    "+totalFormat+"     ";

        String resultFormatter = "%"+(rowLength)+"s";

        System.out.format(resultFormatter, discountString);
        System.out.println();
        System.out.format(resultFormatter, subTotalString);
        System.out.println();
        System.out.format(resultFormatter, taxString);
        System.out.println();
        System.out.format(resultFormatter, totalString);
        System.out.println();

        System.out.printf("-".repeat(rowLength));
        System.out.println();


    }

    public static int printReservationSubMenu() {
		System.out.println("Reservation Booking\nSelect an option:\n");
		System.out.println("1) Create a new reservation booking");
		System.out.println("2) Check reservation booking");
		System.out.println("3) Remove a reservation booking");
		System.out.println("4) Check for expired reservations");
		System.out.println("5) Back to main menu");
		System.out.println("0) Exit Application");

		int choice = input.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    ReservationManager.createReservationBooking();
                    break;
                case 2:
                    ReservationManager.checkReservationBooking();
                    break;
                case 3:
                    ReservationManager.removeReservationBooking();
                    break;
                case 4:
                    ReservationManager.checkExpiredReservations();
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
