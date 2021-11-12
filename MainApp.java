// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	
	// public static ArrayList<Table> tableCollection;
	
	// public static ArrayList<Reservation> reservationCollection;
	
	// private static int tableTrack[] = {2,2,2,2,2};
	
	// public static ArrayList<Staff> staffCollection;
	
	// public static ArrayList<Order> orderCollection;
	
	// public static ArrayList<MenuItem> menuItemCollection;
	
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
	
			sc.close();	
	}
	
	// private static void createTableCollection() {
	// 	int i = 0,j,n = 1,capacity = 2;
	// 	while(capacity <= 10) {
	// 		for(j = 0; j < tableTrack[i]; j++) {
	// 			Table table = new Table(n++,capacity);
	// 			tableCollection.add(table);
	// 		}
	// 		i++;
	// 		capacity += 2;
	// 	}
	// }
}

//pull new attributes as you need
