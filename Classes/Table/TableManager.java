package Classes.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;
import Classes.Time.DateTimeFormatHelper;

/**
 * The Table Manager class
 * manages the collection of tables in the restaurant
 * @author Ma Guangheng
 * @version 1.0
 * @since 2021-11-02
 */
public class TableManager {
	/**
	 * Arraylist to store all the tables.
	 */
	private static ArrayList<Table> tableCollection = new ArrayList<Table>();
	/**
	 * Array to store the number of each type of table.
	 */
	private static final int[] tableTrack = { 2, 2, 2, 2, 2 };
	/**
	 * Initialise the arraylist of table collection.
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
	 * Get the total number of tables.
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
    	Reservation.ReservationSession s;
    	s = DateTimeFormatHelper.inbuiltSession();
    	if(s == null) return;
		ArrayList<Table> booked = ReservationManager.getTableBookedByDateAndSession(date,s);
		for(Table t: booked)
			t.setReserved();
    }
}