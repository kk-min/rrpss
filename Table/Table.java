package Project;

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
	private boolean occupied;
	private boolean reserved;

	public Table(int tableNo, int cap) {
		this.ID = tableNo;
		this.occupied = false;
		this.reserved = false;
		if (cap > 10)
			capacity = 10;
		else
			capacity = cap;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void assign() {
		occupied = true;
		reserved = true;
	}

	public void deassign() {
		occupied = false;
		reserved = false;
	}

	public void reserve() {
		reserved = true;
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

	public static void printTableAvailibilityByDateAndSession(LocalDate date, Reservation.ReservationSession session,
			boolean now) {
		ArrayList<Table> unavailable = Reservation.getTableBookedByDateAndSession(date, session);
		ArrayList<Table> available = getTheOtherHalf(unavailable);
		System.out.printf("%-9s %-10s %-8s\n", "TableID", "Capacity", "Status");
		String status = "Unknown";
		for (Table t : available) {
			if (unavailable.contains(t))
				status = "Reserved";
			if (now && t.isOccupied())
				status = "Occupied";
			System.out.printf("%-9d %-10d %-8s\n", t.getID(), t.getCapacity(), status);
		}
	}
}
