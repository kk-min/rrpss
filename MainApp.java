package Project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainApp {

	public static ArrayList<Table> tableCollection;

	public static ArrayList<Reservation> reservationCollection;

	private static int tableTrack[] = { 2, 2, 2, 2, 2 };

	/*
	 * public static ArrayList<Staff> staffCollection;
	 * 
	 * public static ArrayList<Order> orderCollection;
	 * 
	 * public static ArrayList<MenuItem> menuItemCollection;
	 * 
	 * public static ArrayList<MenuItem[]> menuItemSellRecord;
	 */

	public MainApp() {

	}

	private static void createTableCollection() {
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

	public static void main(String[] args) {
		tableCollection = new ArrayList<Table>();
		reservationCollection = new ArrayList<Reservation>();
		createTableCollection();
		int i;
		for (i = 0; i < tableCollection.size(); i++) {
			System.out.printf("Table ID %d: capacity %d\n", tableCollection.get(i).getID(),
					tableCollection.get(i).getCapacity());
			// ReservationMenuUI.
		}
		UIExecuteTimer.runScheduler();
	}

	private void checkExpiredReservations() {
		Reservation r;
		Iterator<Reservation> iter = reservationCollection.iterator();
		while (iter.hasNext()) {
			r = iter.next();
			if (r.getResvDate().equals(LocalDate.now()))
				if (DateTimeFormatHelper.getTimeDifferenceMinutes(LocalTime.now(), r.getResvTime()) <= -30) {
					iter.remove();
				}
		}

	}
}
