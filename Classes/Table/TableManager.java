package Classes.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;
import Classes.Time.DateTimeFormatHelper;

public class TableManager {
	/**
	 * Arraylist to store all the table.
	 */
	private static ArrayList<Table> tableCollection = new ArrayList<Table>();
	/**
	 * Array to store number of each type of tables.
	 */
	private static final int[] tableTrack = { 2, 2, 2, 2, 2 };
	/**
	 * Create arraylist table collection. Execute once at the start of the program.
	 */
	public static void initialiseTableCollection() {
		int i = 0, j, n = 1, capacity = 2;
		while (capacity <= 10) {
			for (j = 0; j < tableTrack[i]; j++) {
				Table table = new Table(n++, capacity);
				tableCollection.add(table);
			}
			i++;
			capacity += 2;
		}
	}
	/**
	 * Get total number of tables.
	 * @return Number of tables
	 */
	public static int totalTableNum() {
		return tableCollection.size();
	}
	/**
	 * Get the table object from the table number in integer
	 * @param id Table ID in integer
	 * @return The table object whose ID matches the input ID
	 */
	public static Table getTableByID(int id) {
		for (Table t : tableCollection) {
			if (t.getID() == id)
				return t;
		}
		return null;
	}
	/**
	 * Return an arraylist all available tables whose status is "EMPTY".
	 * @return ArrayList of tables with status "EMPTY"
	 */
	public static ArrayList<Table> getTableAvailabilities() {
		ArrayList<Table> available = new ArrayList<Table>();
		for (Table t : tableCollection) {
			if (t.getStatus() == Table.TStatus.EMPTY)
				available.add(t);
		}
		return available;
	}
	/**
	 * Find a table to accommodate for a walk-in customer. Return the ID of the table found.
	 * @param pax Number of customers
	 * @return ID of the table found
	 */
	public static int findTableForWalkIn(int pax){
		ArrayList<Table> available = getTableAvailabilities();
		for(Table t : available){
			if(t.getCapacity() >= pax)
				return t.getID();
		}
		return -1;
	}
	/**
	 * Find and print all tables with status "EMPTY".
	 */
	public static void printTableAvailabilities() {
		ArrayList<Table> available = getTableAvailabilities();
		System.out.println("These tables are currently available:");
		for (Table t : available) {
			System.out.printf("Table %-9d - %-9d pax %n", t.getID(), t.getCapacity());
		}
	}
	/**
	 * Print the status of the tables in a given date and session. If now is set, the function will print the results
	 * of the current session. The tables will be available, reserved or occupied. If now is not set, the function will
	 * print the result in future. The tables will be either available or reserved.
	 * @param date Date of interest
	 * @param session Session of interest. AM or PM.
	 * @param now boolean to determine whether to print the current status or the future
	 */
	public static void printTableStatusByDateAndSession(LocalDate date, Reservation.ReservationSession session,
			boolean now) {
		ArrayList<Table> unavailable = ReservationManager.getTableBookedByDateAndSession(date, session);
		System.out.printf("%-9s %-10s %-8s\n", "TableID", "Capacity", "Status");
		String status = "";
		for (Table t : tableCollection) {
			status = "Available";
			if (unavailable.contains(t))
				status = "Reserved";
			if (now && t.getStatus() == Table.TStatus.OCCUPIED)
				status = "Occupied";
			System.out.printf("%-9d %-10d %-8s\n", t.getID(), t.getCapacity(), status);
		}
	}
	/**
	 * Get the complement among all tables of a given set of tables.
	 * @param input the given set of tables
	 * @return the complement of the input
	 */
	public static ArrayList<Table> getComplement(ArrayList<Table> input) {
		ArrayList<Table> output = new ArrayList<Table>(tableCollection);
		for (Table t : input)
			output.remove(t);
		output.sort(Comparator.comparingInt(o -> o.getCapacity()));
		return output;
	}
	/**
	 * If the current time is within a session of operation, update the table status to "RESERVED" if the table 
	 * is reserved in the current session. Else the function returns.
	 */
	public static void updateTableStatus() {
    	LocalDate date = DateTimeFormatHelper.inbuiltDate();
    	LocalTime time = DateTimeFormatHelper.inbuiltTime();
    	Reservation.ReservationSession s;
    	s = DateTimeFormatHelper.inbuiltSession(time);
    	if(s == null) return;
		ArrayList<Table> booked = ReservationManager.getTableBookedByDateAndSession(date,s);
		for(Table t: booked)
			t.setReserved();
    }
}
