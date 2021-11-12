package Classes.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import Classes.Table.Table;
import Classes.Table.TableManager;
import Classes.Time.DateTimeFormatHelper;

public class ReservationManager {

	private static Scanner input = new Scanner(System.in);

	private static ArrayList<Reservation> reservationCollection;

	//  TODO Erli: can this main func be removed
	// public static void main(String[] args) {
	// 	MainApp.main(args);
	// 	ReservationManager ui = new ReservationManager();
	// 	while (true)
	// 		ui.generateMenuScreen();
	// }// debug

	public ReservationManager() {
		reservationCollection = new ArrayList<Reservation>();
	}

	public static void createReservationBooking() {
		Reservation r = null;
		String custName;
		String custContact;
		int numPax = 0;
		int tableNum = 0;
		LocalDate resvDate = LocalDate.now();
		LocalTime resvTime = LocalTime.now();
		char resvSession = ' ';

		String userDate = "";
		boolean correctDate = false;
		boolean correctTime = false;
		boolean isToday = false;

		System.out.println("Create Reservation Booking");
		try {
			System.out.print("Enter the name: ");
			custName = input.nextLine();

			System.out.print("Enter the contact number: ");
			custContact = input.nextLine();

			while (!correctDate) {
				System.out.println("Enter reservation date in the format of <dd/mm/yyyy>: ");
				userDate = input.nextLine();

				correctDate = DateTimeFormatHelper.validateDate(userDate);

				if (correctDate) {
					resvDate = DateTimeFormatHelper.formatToLocalDate(userDate);
					isToday = resvDate.isEqual(DateTimeFormatHelper.getTodayDate(false));

					if (DateTimeFormatHelper.compareIfBeforeToday(resvDate)) {
						System.out.println("ERROR! The date entered is already over.");
						correctDate = false;
					}

				} else {
					System.out.println("ERROR! Received invalid date input.");
				}
			}

			while (!correctTime) {
				System.out.println("The opening hours are 10:00 to 16:00, and 18:00 to 00:00.");
				System.out.println("Enter reservation time in the 24-hour format of <hh:mm>: ");
				resvTime = DateTimeFormatHelper.formatToLocalTime(input.nextLine());
				// System.out.print(resvTime); //debug

				if (!isToday || !(DateTimeFormatHelper.getTimeDifferenceMinutes(LocalTime.now(), resvTime) <= 0)) {
					if (DateTimeFormatHelper.checkResvTimeSession(resvTime, LocalTime.of(16, 0), LocalTime.of(18, 0))) {
						resvSession = 'A';
						correctTime = true;
					} else if (DateTimeFormatHelper.checkResvTimeSession(resvTime, LocalTime.of(18, 0),
							LocalTime.of(23, 59))) {
						resvSession = 'P';
						correctTime = true;
					} else {
						System.out.println("The restaurant is not in operation at the time you entered.");
						correctTime = false;
					}
				} else {
					System.out.println("The time entered is passed! Current time is " + LocalTime.now() + ".");
					correctTime = false;
				}
			}

			while (numPax <= 0 || numPax > 10) {
				System.out.print("Enter pax amount: ");
				numPax = input.nextInt();
				if (numPax <= 0) {
					System.out.println("You cannot book a reservation for 0 pax.");
				} else if (numPax > 10) {
					System.out.println("Sorry! The restaurant's maximum seating is 10 people.");
				}
			}

			tableNum = findTableForReservation(numPax, resvDate, resvSession);

			if (tableNum > 0) {
				int lastNum;
				if (reservationCollection.isEmpty())
					lastNum = 1;
				else
					lastNum = reservationCollection.get(reservationCollection.size() - 1).getResvId()
							+ 1;
				r = new Reservation(lastNum, resvDate, resvTime, resvSession, custContact, custName, numPax, tableNum);
				reservationCollection.add(r);
				System.out.println("Your reservation has been successfully recorded! Your reservation ID is " + lastNum
						+ " , and your assigned table is " + tableNum + ".");
				System.out.println(
						"Please take notice that your reservation will expire after 30 minutes of your booking time.");
			} else {
				System.out.println(
						"There are no available tables that can cater the number of pax for the day and session. We're sorry!");
			}

			input.nextLine();
		} catch (DateTimeParseException e) {
			System.out.println("ERROR! Input date or time format is wrong. (" + e.getLocalizedMessage() + ")");
		} catch (InputMismatchException e) {
			System.out.println("ERROR! Please input a valid number of pax. (" + e.getLocalizedMessage() + "}");
		}
	}

	public static ArrayList<Table> getTableBookedByDateAndSession(LocalDate date, Reservation.ReservationSession session) {
		ArrayList<Table> bookedTables = new ArrayList<Table>();
		for (Reservation resv : reservationCollection) {
			if (resv.getResvDate().equals(date) && resv.getResvSession() == session)
				bookedTables.add(TableManager.getTableByID(resv.getTableID()));
		}
		return bookedTables;
	}

	private static int findTableForReservation(int cusCount, LocalDate resvDate, char session) {
		ArrayList<Table> available, unavailable = new ArrayList<Table>();
		Reservation.ReservationSession s = session == 'A' ? Reservation.ReservationSession.AM
				: Reservation.ReservationSession.PM;
		unavailable = getTableBookedByDateAndSession(resvDate, s);
		for (Table i : unavailable) {
			System.out.println("Table ID " + i.getID());
		}
		available = TableManager.getTheOtherHalf(unavailable);
		for (Table t : available) {
			if (t.getCapacity() >= cusCount)
				return t.getID();
		}
		return -1;
	}

	public static void checkReservationBooking() {
		int count = 0;
		System.out.print("Enter your reservation Id: ");
		int Id = input.nextInt();
		count = printReservationLine(Id);

		if (count == 0) {
			System.out.println("Invalid reservation Id! Please check again!");
		}
	}

	public static void removeReservationFromList(int Id) {
		if (Id == -1)
			return;

		Iterator<Reservation> iter = reservationCollection.iterator();
		while (iter.hasNext()) {
			Reservation r = iter.next();
			if (r.getResvId() == Id) {
				iter.remove();
				System.out.println("Reservation ID " + Id + " has been successfully removed.");
				return;
			}
		}

		System.out.println("Invalid Reservation ID. No removals made.");
	}

	public static void removeReservationBooking() {
		int count = 0;

		System.out.println("Remove Reservation Booking");
		System.out.print("Enter the reservation Id: ");
		int resvId = input.nextInt();
		input.nextLine();

		count = printReservationLine(resvId);

		if (count == 1) {
			System.out.print("Are you sure you want to delete this reservation (Y/N)? ");
			switch (Character.toUpperCase(input.nextLine().charAt(0))) {
			case 'Y':
				removeReservationFromList(resvId);
				break;
			case 'N':
				break;
			default:
				System.out.println("Invalid option. Returning Reservation Menu...");
				break;
			}
		} else
			System.out.println("Invalid reservation Id! Please check again!");
	}

	public static void checkExpiredReservations() {
		Reservation r;
		Iterator<Reservation> iter = reservationCollection.iterator();
		while (iter.hasNext()) {
			r = iter.next();
			if (r.getResvDate().equals(LocalDate.now()))
				if (DateTimeFormatHelper.getTimeDifferenceMinutes(LocalTime.now(), r.getResvTime()) <= -30
						&& !(TableManager.getTableByID(r.getTableID()).getStatus() == Table.TStatus.OCCUPIED)) {
					System.out.println("Reservation " + r.getResvId() + "has expired and removed.");
					TableManager.getTableByID(r.getTableID());
					iter.remove();
				}
		}

	}

	private static void printReservationLine(Reservation r) {
		if (r.getResvDate().equals(LocalDate.now()))
			if (DateTimeFormatHelper.getTimeDifferenceMinutes(LocalTime.now(), r.getResvTime()) <= -30) {
				System.out.println("Sorry, your reservation has expired.");
				checkExpiredReservations();
			}
		System.out.printf("%-6d %-15s %-10s %-10s %-15s %-30s %-3d %-9d\n", r.getResvId(),
				DateTimeFormatHelper.formatToStringDate(r.getResvDate()),
				r.getResvSession() == Reservation.ReservationSession.AM ? 'A' : 'P',
				DateTimeFormatHelper.formatToStringTime(r.getResvTime()), r.getCustomerContact(), r.getCustomerName(),
				r.getNumPax(), r.getTableID());
	}

	private static int printReservationLine(int resvId) {
		int count = 0;
		System.out.println("Below are the reservations linked to the reservation number " + resvId);
		System.out.printf("%-6s %-15s %-10s %-10s %-15s %-30s %-3s %-9s\n", "ID", "Date", "Session", "Time", "Tel. No",
				"Name", "Pax", "Table No.");
		System.out.println("");
		for (Reservation r : reservationCollection) {
			if (resvId == r.getResvId()) {
				printReservationLine(r);
				count++;
			}
		}
		return count;
	}

	public static int getTableIDByReservationID(int id) {
		for (Reservation r : reservationCollection) {
			if (r.getResvId() == id)
				return r.getTableID();
		}
		return -1;
	}

	public static ArrayList<Reservation> getReservationCollection() {
		return reservationCollection;
	}
}
