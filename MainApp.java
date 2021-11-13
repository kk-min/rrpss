import java.util.Scanner;

import Classes.AMenuItem.MenuManager;
import Classes.Order.OrderManager;
import Classes.Printer.MenuSubMenu;
import Classes.Printer.OrderSubMenu;
import Classes.Printer.PrintReport;
import Classes.Printer.Printer;
import Classes.Printer.ReservationSubMenu;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;
import Classes.Time.TimerExecutor;
/**
 * MainApp for RRPSS project
 * @version 1.0
 */

public class MainApp {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {

		String restaurantName = Printer.restaurantName;
		int rowLength = Printer.rowLength;	// TODO: think of a better way to do this

		MenuManager.initialiseMenu();
		TableManager.initialiseTableCollection();
		StaffManager.initialiseStaffList();
		TimerExecutor.runScheduler();

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

			do {
				System.out.print("Enter your choice (0-6): ");
				choice = input.nextInt();
			} while (choice > 6 || choice < 0);

			switch(choice) {
				case 1: //Menu submenu
					subMenuResult = MenuSubMenu.print();
					break;
				case 2:	//Order submenu
					subMenuResult = OrderSubMenu.print();
					break;
				case 3:	// Reservation submenu
					subMenuResult = ReservationSubMenu.print();
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
		System.exit(0);
	}
}
