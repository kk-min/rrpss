import java.util.Scanner;

import Classes.AMenuItem.MenuManager;
import Classes.Printer.MenuSubMenu;
import Classes.Printer.OrderSubMenu;
import Classes.Printer.PrintReport;
import Classes.Printer.Printable;
import Classes.Printer.ReservationSubMenu;
import Classes.Staff.StaffManager;
import Classes.Table.TableManager;
import Classes.Time.DateTimeFormatHelper;
import Classes.Time.TimerExecutor;
import java.util.InputMismatchException;
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
			Scanner sc = new Scanner(System.in);

			String restaurantName = "HELLOWORLD";
			int rowLength = 63;
			

			int choice = 0, subchoice = 0;
			while (choice <= 5) {
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
				System.out.println("1. Menu");
				System.out.println("2. Order");
				System.out.println("3. Reservation");
				System.out.println("4. Print Order Invoice");
				System.out.println("5. Print Sale Revenue Report");
				System.out.println("6. Exit");

				//Line 11:
				System.out.printf("-".repeat(rowLength));
				System.out.println();

				System.out.print("Enter your choice: ");
				do {
					choice = sc.nextInt();
				} while (choice > 5 || choice <= 0);
	
				switch(choice) {
					case 1: //Menu submenu
						int exit = 1;
        					Menumanager.initiateMenu();
        					do{
       						 //generateMenuScreen:exit code=-1
        					exit = Menumanager.generateMenuScreen();} while(exit != -1);
						break;
					case 2:	//Order submenu
						while (subchoice < 5) {
							System.out.println("Select an option:");
							System.out.println();
							System.out.println("1. Create Order");
							System.out.println("2. View Order");
							System.out.println("3. Add item to Order");
							System.out.println("4. Remove item from Order");
							System.out.println("5. Go Back");
						
							System.out.printf("-".repeat(rowLength));
							System.out.println();

							System.out.print("Enter your choice: ");
							do {
								subchoice = sc.nextInt();
							} while (subchoice > 5 || subchoice <= 0);

							switch (subchoice) {
								case 1:
									OrderInterface.create(staffCollection);
									break;
								case 2:
									OrderInterface.view(OngoingOrders);
									break;
								case 3:
									OrderInterface.add(OngoingOrders);
									break;
								case 4:
									OrderInterface.remove(OngoingOrders, OrderHistory);
							}
						}
						break;
					case 3:	// Reservation submenu
						while (subchoice < 5) {
							System.out.println("Select an option:");
							System.out.println();
							System.out.println("1. Create Reservation booking");
							System.out.println("2. Check Reservation booking");
							System.out.println("3. Remove Reservation booking");
							System.out.println("4. Check Table availability");
							System.out.println("5. Go back");

							System.out.printf("-".repeat(rowLength));
							System.out.println();

							System.out.print("Enter your choice: ");
							do {
								subchoice = sc.nextInt();
							} while (subchoice > 5 || subchoice <= 0);

							switch (subchoice) {
								case 1:
								case 2:
								case 3:
								case 4:
							}
						}
						break;
					case 4:	// Print Order Invoice
						// OrderInterface.checkout(OrderHistory);
						break;
					case 5: // Print Sale Revenue Report
						// TODO
						break;
				}
			}

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
		String restaurantName = Printable.restaurantName;
		int rowLength = Printable.rowLength;

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
