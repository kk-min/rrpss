package Classes.Table;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;

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
		this.status = TStatus.RESERVED;
	}

	public void setOccupied() {
		this.status = TStatus.OCCUPIED;
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
}
