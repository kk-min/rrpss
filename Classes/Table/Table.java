package Classes.Table;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;

// TODO: initialise the tableCollection array here (it wont exist in MainApp) & refactor all necessary code in the functions below

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
		for (Reservation r : ReservationManager.getReservationCollection())
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
}
