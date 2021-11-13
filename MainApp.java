import java.util.Scanner;

import Classes.Order.OrderManager;
import Classes.Printer.PrintReceipt;
import Classes.Printer.PrintReport;
import Classes.Printer.SubMenuPrinter;
import Classes.Table.TableManager;

public class MainApp {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {

		String restaurantName = "HELLOWORLD";
		int rowLength = 63;
		

		int choice = 1, subMenuResult = -1;
		while (choice != 0 && subMenuResult != 1) {
			//Line 1:
			System.out.printf("-".repeat(rowLength));
			System.out.println();

			//Line 2:
			String leftFormat = "%-"+((rowLength/2)-(restaurantName.length()/2))+"s";
			String rightFormat = "%"+((rowLength/2)-(restaurantName.length()/2))+"s";
			System.out.format(leftFormat, " ");
			System.out.print(restaurantName);
			System.out.format(rightFormat, " ");
			System.out.println();

			//Line 3:
			System.out.printf("-".repeat(rowLength));
			System.out.println();

			//Line 4+:
			System.out.println("Select an option:");
			System.out.println();
			System.out.println("1) Menu");
			System.out.println("2) Order");
			System.out.println("3) Reservation");
			System.out.println("4) Check current table availabilities");
			System.out.println("5) Print Order Invoice");
			System.out.println("6) Print Sale Revenue Report");
			System.out.println("0) Exit Application");

			//Line 11:
			System.out.printf("-".repeat(rowLength));
			System.out.println();

			System.out.print("Enter your choice: ");
			do {
				choice = input.nextInt();
			} while (choice > 5 || choice < 0);

			switch(choice) {
				case 1: //Menu submenu
					subMenuResult = SubMenuPrinter.printMenuSubMenu();
					break;
				case 2:	//Order submenu
					subMenuResult = SubMenuPrinter.printOrderSubMenu();
					break;
				case 3:	// Reservation submenu
					subMenuResult = SubMenuPrinter.printReservationSubMenu();
					break;
				case 4: // Check table availability
					TableManager.printTableAvailabilities();
					break;
				case 5:	// Print Order Invoice
					OrderManager.checkout();
					break;
				case 6: // Print Sale Revenue Report
					PrintReport.print();
					break;
			}
		}
		System.out.println("System exiting... thank you for visiting our restaurant!");
	}
}
