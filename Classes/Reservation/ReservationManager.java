package Classes.Reservation;
import Classes.Table.Table;
import Classes.Table.TableManager;
import Classes.Time.DateTimeFormatHelper;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

/**
 * The ReservationManager Class
 * Create, check, delete and list the reservations and automatically delete the expired reservations.
 * @author  Zhang Erli
 * @author  Her Huey
 * @version 1.0
 * @since   2021-11-02
 */
public class ReservationManager {

	/**
     * The arraylist storing all the reservation records
     */
	private static ArrayList<Reservation> reservationCollection = new ArrayList<Reservation>();

    /**
     * Scanner object for taking in user input
     */
	private static Scanner input = new Scanner(System.in);	

	/**
     * Accessor for reservation collection
     *
     * @return the reservation collection in arraylist
     */
	public static ArrayList<Reservation> getReservationCollection() {
		return reservationCollection;
	}
     /**
      * ID to be assigned to the reservation.
      */
	  public static int globalID = 1;
    /**
     * Creating a new reservation booking
	 * Get inputs from user: Customer name, customer contact, date, time of reservation and no of pax
     */
	public static void createReservationBooking() {

		//Variables for creating a Reservation
		Reservation r = null;
		String userDate = "";
		LocalDate resvDate = LocalDate.now();
		LocalTime resvTime = LocalTime.now();
		char resvSession = ' ';
		String custContact;
		String custName;
		int numPax = 0;
		int tableNum = 0;

		//Boolean checker for date and time
		boolean correctDate = false;
		boolean correctTime = false;
		boolean isToday = false;

		System.out.println("Create Reservation Booking");
		try { 
			//Enter the name of the customer
			System.out.print("Enter the name: ");
			custName = input.nextLine();

			//Enter the contact number of the customer
			System.out.print("Enter the contact number: ");
			custContact = input.nextLine();

			//Enter the reservation date
			while (!correctDate) {
				System.out.println("Enter reservation date in the format of <dd/mm/yyyy>: ");
				userDate = input.nextLine();

				//Check if the input date is valid
				correctDate = DateTimeFormatHelper.validateDate(userDate);

				if (correctDate) {
					resvDate = DateTimeFormatHelper.formatToLocalDate(userDate);
					isToday = resvDate.isEqual(DateTimeFormatHelper.inbuiltDate());

					//Check if the input date is already over
					if (DateTimeFormatHelper.compareIfBeforeToday(resvDate)) {
						System.out.println("ERROR! The date entered is already over.");
						correctDate = false;
					}

				} else {
					System.out.println("ERROR! Received invalid date input.");
				}
			}

			//Enter the reservation time
			while (!correctTime) {
				System.out.println("The opening hours are 10:00 to 16:00 (AM session), and 18:00 to 00:00 (PM session).");
				System.out.println("Enter reservation time in the 24-hour format of <hh:mm>: ");
				resvTime = DateTimeFormatHelper.formatToLocalTime(input.nextLine());

				//Find the reservation session according to the input reservation time
				if (!isToday || !(DateTimeFormatHelper.getTimeDifferenceMinutes(DateTimeFormatHelper.inbuiltTime(), resvTime) <= 0)) {
					if (DateTimeFormatHelper.checkResvTimeSession(resvTime, LocalTime.of(10, 0), LocalTime.of(16, 0))) {
					  resvSession = 'A';
					  correctTime = true;
					} else if (DateTimeFormatHelper.checkResvTimeSession(resvTime, LocalTime.of(18, 0),
						LocalTime.of(23, 59))) {
					  resvSession = 'P';
					  correctTime = true;
					} else {
					  System.out.println("The restaurant is not in operation at the time which you entered.");
					  correctTime = false;
					}
				  } else {
					System.out.println("The time entered has already passed! Current time is " + DateTimeFormatHelper.formatToStringTime(DateTimeFormatHelper.inbuiltTime()) + ".");
					correctTime = false;
				  }
			}

			//Enter the number of customers
			while (numPax <= 0 || numPax > 10) {
				System.out.print("Enter number of customers: ");
				numPax = input.nextInt(); input.nextLine();
				if (numPax <= 0) {
					System.out.println("You cannot have less than 1 person.");
				} else if (numPax > 10) {
					System.out.println("Sorry! The restaurant's maximum seating is 10 people.");
				}
			}

			//Find the appropriate table for customers according to number of pax, reservation date and session
			tableNum = findTableForReservation(numPax, resvDate, resvSession);

			//If exists, assign the table to the customer and finish the reservation
			if (tableNum > 0) {
				int assignedTableNum = globalID++;
				r = new Reservation(assignedTableNum, resvDate, resvTime, resvSession, custContact, custName, numPax, tableNum);
				reservationCollection.add(r);
				System.out.println("Your reservation has been successfully recorded! Your reservation ID is " + assignedTableNum + ".");
				System.out.println(
						"Please take note that your reservation will expire 30 minutes of your booking time.");
			} else {
				System.out.println(
						"The restaurant is full for the day and session you entered. We're sorry!");
			}
		} catch (DateTimeParseException e) {
			System.out.println("ERROR! Please make sure the date or time inputted is in correct format! (" + e.getLocalizedMessage() + ")");
		} catch (InputMismatchException e) {
			System.out.println("ERROR! Please make sure the input is valid! (" + e.getLocalizedMessage() + "}");
		}
	}

	/**
     * Method to check the booked (unavailable) tables at the given date and session. The booked tables will be returned
	 * in an arraylist
     *
     * @param date     The given date to check tables' availability
	 * @param session  The given session to check tables' availability
	 * @return The arraylist of tables that are booked, empty if all table are available at that given date and session
     */
	public static ArrayList<Table> getTableBookedByDateAndSession(LocalDate date, Reservation.ReservationSession session) {
		ArrayList<Table> bookedTables = new ArrayList<Table>();
		for (Reservation resv : reservationCollection) {
			if (resv.getResvDate().equals(date) && resv.getResvSession() == session)
				bookedTables.add(TableManager.getTableByID(resv.getTableID()));
		}
		return bookedTables;
	}

	/**
     * Method to find the first suitable table given the number of customers, reservation date and session
	 * The table will be arranged according to the capacity, so the output will be the first table that best fit the requirements
     *
     * @param cusCount     The given number of customers
	 * @param resvDate     The given date to check tables' availability
	 * @param session      The given session to check tables' availability
	 * @return the first table id if there exists a table that fit the requirements, -1 if all tables are occupied
     */
	public static int findTableForReservation(int cusCount, LocalDate resvDate, char session) {
		ArrayList<Table> available, unavailable = new ArrayList<Table>();
		Reservation.ReservationSession s = session == 'A' ? Reservation.ReservationSession.AM
				: Reservation.ReservationSession.PM;
		unavailable = getTableBookedByDateAndSession(resvDate, s);
		available = TableManager.getComplement(unavailable);
		for (Table t : available) {
			if (t.getCapacity() >= cusCount)
				return t.getID();
		}
		return -1;
	}

	/**
     * Method to print all reservations after the current time
	 * The reservation will be printed in ascending order of reservation id
	 * The expired reservations and the past reservations will not be printed
	 * 
     */
	public static void printAllReservations() {
		System.out.println("Here are all the current reservations:");
		System.out.printf("%-6s %-15s %-10s %-10s %-15s %-30s %-3s %-9s\n", "ID", "Date", "Session", "Time", "Tel. No",
			"Name", "Pax", "Table No.");
		System.out.println("");
		boolean passed = false;
		for (Reservation r : reservationCollection) {
			if (DateTimeFormatHelper.compareIfBeforeToday(r.getResvDate())) {
				passed = true;
			} else if (r.getResvDate().isEqual(DateTimeFormatHelper.inbuiltDate())) {
				if (r.getResvTime().isBefore(DateTimeFormatHelper.inbuiltTime())) {
					passed = true;
				}
			}
			if (!passed) {
				System.out.printf("%-6d %-15s %-10s %-10s %-15s %-30s %-3d %-9d\n", r.getResvId(),
						DateTimeFormatHelper.formatToStringDate(r.getResvDate()),
						r.getResvSession() == Reservation.ReservationSession.AM ? 'A' : 'P',
						DateTimeFormatHelper.formatToStringTime(r.getResvTime()), r.getCustomerContact(), r.getCustomerName(),
						r.getNumPax(), r.getTableID());
			}
		}
	}

	/**
     * Method to check the reservation booking information according to the input reservation id
	 * If there is no reservation record linked to the reservation number, -1 will be returned for further checking purposes
	 * 
	 * @return the reservation Id the user wants to check, -1 if the input is not valid
     */
	public static int checkReservationBooking() {
		boolean flag = false;
		System.out.print("Enter your reservation Id: ");
		int Id = input.nextInt();
		for (Reservation r : reservationCollection) {
			if (Id == r.getResvId()) {
				System.out.println("Below is the reservation linked to the reservation number " + Id);
				System.out.printf("%-6s %-15s %-10s %-10s %-15s %-30s %-3s %-9s\n", "ID", "Date", "Session", "Time", "Tel. No",
						"Name", "Pax", "Table No.");
				System.out.println("");
				System.out.printf("%-6d %-15s %-10s %-10s %-15s %-30s %-3d %-9d\n", r.getResvId(),
						DateTimeFormatHelper.formatToStringDate(r.getResvDate()),
						r.getResvSession() == Reservation.ReservationSession.AM ? 'A' : 'P',
						DateTimeFormatHelper.formatToStringTime(r.getResvTime()), r.getCustomerContact(), r.getCustomerName(),
						r.getNumPax(), r.getTableID());
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("Invalid reservation Id! Please check again!");
			Id = -1;
		}
		return Id;
	}
	//TODO
	//Add isToday, isCurrentSession, passedThirtyMinutes, notComeYet, changeTableStatusToEmpty

	/**
     * Method to delete the reservation booking information according to the input reservation id
	 * The method will call checkReservationBooking() first to check if the input is valid
	 * If checkReservationBooking() returns -1, it means the input reservation id is not valid
	 * If the input id is correct, the reservation record will be deleted from the list
	 * If the reservation is deleted at its reserved session, the status of table will also be changed to EMPTY
	 * 
     */
	public static void removeReservationBooking() {
		System.out.println("Remove Reservation Booking");
		int Id =  checkReservationBooking();

		if (Id != -1) {
			System.out.print("Are you sure you want to delete this reservation (Y/N)? ");
			switch (Character.toUpperCase(input.nextLine().charAt(0))) {
			case 'Y':
				for(int i=0;i<reservationCollection.size();i++){
					if (Id == reservationCollection.get(i).getResvId()){
						Reservation r = reservationCollection.get(i);
						boolean isToday = isToday(r);
						boolean isCurrentSession = isCurrentSession(r);
						if (isToday && isCurrentSession) {
							changeTableStatusToEmpty(r);
						}
						reservationCollection.remove(i);
						System.out.println("Reservation ID " + Id + " has been successfully removed.");
						break;
					}
				}
				break;
			case 'N':
				System.out.println("Request cancelled.");
				break;
			default:
				System.out.println("Invalid option!");
				break;
			}
		}
	}

	/**
     * Method to check whether the reservation date is today
	 * 
	 * @param r reservation
	 * @return isToday is true if the reservation is today, othervise false
     */	
	public static boolean isToday(Reservation r) {
		return r.getResvDate().equals(DateTimeFormatHelper.inbuiltDate());
	}

	/**
	 * Method to check whether the reservation session is the current session
	 * 
	 * @param r reservation
	 * @return isCurrentSession is true if the reservation session is the current session, othervise false
     */	
	public static boolean isCurrentSession(Reservation r) {
		return r.getResvSession().equals(DateTimeFormatHelper.inbuiltSession(DateTimeFormatHelper.inbuiltTime()));
	}

	/**
     * Method to check whether the reservation has passed for 30 minutes
	 * 
	 * @param r reservation
	 * @return passedThirtyMinutes is true if the reservation has passed for 30 minutes, otherwise false
     */	
	public static boolean passedThirtyMinutes(Reservation r) {
		return DateTimeFormatHelper.getTimeDifferenceMinutes(DateTimeFormatHelper.inbuiltTime(), r.getResvTime()) <= -30;
	}

	/**
     * Method to check whether the customers have arrived or not
	 * by checking the status of the table they reserved
	 * 
	 * @param r reservation
	 * @return notComeYet is true if the customers haven't arrvied, otherwise false
     */	
	public static boolean notComeYet(Reservation r) {
		return !(TableManager.getTableByID(r.getTableID()).getStatus() == Table.TStatus.OCCUPIED);
	}

	/**
     * Method to change the table status to EMPTY if the reservation is deleted at its reserved session
	 * 
	 * @param r reservation
     */	
	public static void changeTableStatusToEmpty(Reservation r) {
		TableManager.getTableByID(r.getTableID()).setEmpty();
	}	

	/**
     * Method to automatedly delete the reservation after 30 minutes of its reservation time and the customer(s) haven't showed up
	 * 
	 * This method will be called once a minute in the MainApp
     */
	public static void checkExpiredReservations() {
		for(int i=0;i<reservationCollection.size();i++){
			Reservation r = reservationCollection.get(i);
			boolean isToday = isToday(r);
			boolean passedThirtyMinutes = passedThirtyMinutes(r);
			boolean notComeYet = notComeYet(r);
			if (isToday && passedThirtyMinutes && notComeYet) {
				changeTableStatusToEmpty(r);
				System.out.println("Reservation ID " + r.getResvId() + " has been successfully removed.");
				reservationCollection.remove(i);
			}
		}
	}


	/**
     * Method to return the reserved table id by the input reservation ID
	 * 
	 * @param id reservation id
	 * @return the table id according to the reservation id, -1 if the reservation id is not valid
     */
	public static int getTableIDByReservationID(int id) {
		for (Reservation r : reservationCollection) {
			if (r.getResvId() == id)
				return r.getTableID();
		}
		return -1;
	}
}
