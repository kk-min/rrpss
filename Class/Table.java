public class Table {
	private int ID;
	private int capacity;
	private boolean occupied;
	private static int tableNo = 1;

	public Table(int capacity) {
		this.ID = tableNo++;
		this.capacity = capacity;
		this.occupied = false;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void assign() {
		occupied = true;
	}

	public void deassign() {
		occupied = false;
	}
	
	public int getID() {
		return ID;
	}
}

// find table for reservation(no, resDate, session)
