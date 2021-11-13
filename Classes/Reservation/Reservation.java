package Classes.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

import Classes.Table.TableManager;

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
			int tableId) {
		this.Id = id;
		this.resvDate = rd;
		this.resvTime = rt;
		this.resvSession = session == 'A' ? ReservationSession.AM : ReservationSession.PM;
		this.customerContact = custContact;
		this.customerName = custName;
		this.numPax = pax;
		this.tableID = tableId;
		TableManager.getTableByID(tableId).setReserved();
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
}
