package Classes.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;
import Classes.Time.DateTimeFormatHelper;

public class TableManager {

	private static ArrayList<Table> tableCollection = new ArrayList<Table>();

	private static final int[] tableTrack = { 2, 2, 2, 2, 2 };

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

	public static int totalTableNum() {
		return tableCollection.size();
	}

	public static Table getTableByID(int id) {
		for (Table t : tableCollection) {
			if (t.getID() == id)
				return t;
		}
		return null;
	}

	public static ArrayList<Table> getTableAvailabilities() {
		ArrayList<Table> available = new ArrayList<Table>();
		for (Table t : tableCollection) {
			if (t.getStatus() == Table.TStatus.EMPTY)
				available.add(t);
		}
		return available;
	}
	
	public static int findTableForWalkIn(int pax){
		ArrayList<Table> available = getTableAvailabilities();
		for(Table t : available){
			if(t.getCapacity() >= pax)
				return t.getID();
		}
		return -1;
	}
	
	public static void printTableAvailabilities() {
		ArrayList<Table> available = getTableAvailabilities();
		for (Table t : available) {
			System.out.println("These tables are currently available:");
			System.out.printf("Table %-9d - %-9d pax %n", t.getID(), t.getCapacity());
		}
	}

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

	public static ArrayList<Table> getComplement(ArrayList<Table> input) {
		ArrayList<Table> output = new ArrayList<Table>(tableCollection);
		for (Table t : input)
			output.remove(t);
		output.sort(Comparator.comparingInt(o -> o.getCapacity()));
		return output;
	}

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
