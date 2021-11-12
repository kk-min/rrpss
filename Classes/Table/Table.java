package Classes.Table;

import Project.MainApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalTime;
import java.time.LocalDate;

public class Table {
	private int capacity;
	public static int MAX_CAPACITY = 10;
	private int ID;
	private TStatus status;

	public enum TStatus {
		EMPTY, RESERVED, OCCUPIED
	};

	public Table(int tableNo, int cap) {
		this.ID = tableNo;
		this.status = TStatus.EMPTY;
		if (cap > 10)
			capacity = 10;
		else
			capacity = cap;
	}

	public void setEmpty() {
		this.status = TStatus.EMPTY;
	}

	public void setReserved() {
		if (this.status == TStatus.OCCUPIED) return;
		else this.status = TStatus.RESERVED;
	}

	public void setOccupied() {
		this.status = TStatus.OCCUPIED;
	}

	public void deoccupy() {
		for (Reservation r : MainApp.reservationCollection)
			if (r.getTableID() == this.ID) {
				this.status = TStatus.RESERVED;
				return;
			}
		this.status = TStatus.EMPTY;
	}

	public TStatus getStatus() {
		return status;
	}

	public int getID() {
		return ID;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int cap) {
		if (cap > 10)
			capacity = 10;
		else
			capacity = cap;
	}

	public static Table getTableByID(int id) {
		for (Table t : MainApp.tableCollection) {
			if (t.getID() == id)
				return t;
		}
		return null;
	}

	public static ArrayList<Table> getTheOtherHalf(ArrayList<Table> input) {
		ArrayList<Table> output = new ArrayList<Table>(MainApp.tableCollection);
		for (Table t : input)
			output.remove(t);
		output.sort(Comparator.comparingInt(o -> o.capacity));
		return output;
	}

	public static void printTableStatusByDateAndSession(LocalDate date, Reservation.ReservationSession session,
			boolean now) {
		ArrayList<Table> unavailable = Reservation.getTableBookedByDateAndSession(date, session);
		System.out.printf("%-9s %-10s %-8s\n", "TableID", "Capacity", "Status");
		String status = "";
		for (Table t : MainApp.tableCollection) {
			status = "Available";
			if (unavailable.contains(t))
				status = "Reserved";
			if (now && t.getStatus() == Classes.Table.TStatus.OCCUPIED)
				status = "Occupied";
			System.out.printf("%-9d %-10d %-8s\n", t.getID(), t.getCapacity(), status);
		}
	}
}
