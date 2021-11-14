import java.util.Scanner;

import Classes.AMenuItem.MenuManager;
import Classes.Printer.MenuSubMenu;
import Classes.Printer.OrderSubMenu;
import Classes.Printer.PrintReport;
import Classes.Printer.Printer;
import Classes.Printer.ReservationSubMenu;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;
import Classes.Time.DateTimeFormatHelper;
import Classes.Time.TimerExecutor;
/**
 * MainApp for RRPSS project
 * this is where the main program will be run
 * 
 * @version 1.0
 * @since   2021-11-12
 */

public class MainApp {
	/**
     * Scanner object for taking user input
     */
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * main function that prompts selection of tasks to perform
	 * @param args command line arguments
	 */
	public static void main(String args[]) {

		// initialisations
		MenuManager.initialiseMenu();
		TableManager.initialiseTableCollection();
		StaffManager.initialiseStaffList();
		TimerExecutor.runScheduler();

		// program
		int choice = 1, subMenuResult = -1;
		while (choice != 0 && subMenuResult != 1) {
			printMainMenu();

			do {
				System.out.print("Enter your choice (0-6): ");
				choice = input.nextInt(); input.nextLine();
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
					TableManager.printTableStatusByDateAndSession(DateTimeFormatHelper.inbuiltDate(),
						DateTimeFormatHelper.inbuiltSession(),true);
					break;
				case 5:	// Print Sales Revenue Report
					PrintReport.print();
					break;
				case 6:	// Advance Time
					DateTimeFormatHelper.advanceTime();
					break;
			}
		}
		System.out.println("System exiting... thank you for using our system!");
		System.exit(0);
	}

	/**
	 * print out main menu for user to view functionalities available
	 */
	private static void printMainMenu() {
		String restaurantName = Printer.restaurantName;
		int rowLength = Printer.rowLength;

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
		System.out.println("4) Check Current Table Availabilities");
		System.out.println("5) Print Sale Revenue Report");
		System.out.println("6) Advance Time");
		System.out.println("0) Exit Application");

		//Line 11:
		System.out.printf("-".repeat(rowLength));
		System.out.println();
	}
}
