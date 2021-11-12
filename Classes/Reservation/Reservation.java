package Classes.Reservation;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import Project.Table;
import Project.MainApp;

public class Reservation {
	public enum ReservationSession {
		AM, PM
	};

	private int Id;
	private LocalDate resvDate;
	private LocalTime resvTime;
	private String customerContact;
	private String customerName;
	private int numPax;
	private int tableID;
	private ReservationSession resvSession;

	public Reservation(int id, LocalDate rd, LocalTime rt, char session, String custContact, String custName, int pax,
			int t) {
		this.Id = id;
		this.resvDate = rd;
		this.resvTime = rt;
		this.resvSession = session == 'A' ? ReservationSession.AM : ReservationSession.PM;
		this.customerContact = custContact;
		this.customerName = custName;
		this.numPax = pax;
		this.tableID = t;
		Table.getTableByID(t).setReserved();
	}

	public int getResvId() {
		return Id;
	}

	public LocalDate getResvDate() {
		return resvDate;
	}

	public LocalTime getResvTime() {
		return resvTime;
	}

	public ReservationSession getResvSession() {
		return resvSession;
	}

	public int getNumPax() {
		return numPax;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public int getTableID() {
		return tableID;
	}

	public static ArrayList<Table> getTableBookedByDateAndSession(LocalDate date, ReservationSession session) {
		ArrayList<Table> bookedTables = new ArrayList<Table>();
		for (Reservation resv : MainApp.reservationCollection) {
			if (resv.getResvDate().equals(date) && resv.getResvSession() == session)
				bookedTables.add(Table.getTableByID(resv.getTableID()));
		}
		return bookedTables;
	}

	public static void removeReservationFromList(Reservation r) {
		MainApp.reservationCollection.remove(r);
	}

	public static void removeReservationFromList(int Id) {
		if (Id == -1)
			return;

		Iterator<Reservation> iter = MainApp.reservationCollection.iterator();
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
}
