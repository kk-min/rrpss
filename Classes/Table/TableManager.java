package Classes.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;

public class TableManager {
    
    private static ArrayList<Table> tableCollection;

    public TableManager() {
        tableCollection = new ArrayList<Table>();
        initialisetableCollection();
    }

    public static void initialisetableCollection()
	{
		Table t1 = new Table(1, 2);
        Table t2 = new Table(2, 2);
        Table t3 = new Table(3, 4);
        Table t4 = new Table(4, 4);
        Table t5 = new Table(5, 6);
        Table t6 = new Table(6, 6);
        Table t7 = new Table(7, 8);
        Table t8 = new Table(8, 8);
        Table t9 = new Table(9, 10);
        Table t10 = new Table(10, 10);
		tableCollection.add(t1); tableCollection.add(t2); tableCollection.add(t3);
        tableCollection.add(t4); tableCollection.add(t5); tableCollection.add(t6);
        tableCollection.add(t7); tableCollection.add(t8); tableCollection.add(t9);
        tableCollection.add(t10);
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

	// TODO: Check Table Availability function

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

    public static ArrayList<Table> getTheOtherHalf(ArrayList<Table> input) {
		ArrayList<Table> output = new ArrayList<Table>(tableCollection);
		for (Table t : input)
			output.remove(t);
		output.sort(Comparator.comparingInt(o -> o.getCapacity()));
		return output;
	}
}
