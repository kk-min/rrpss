package Classes.Table;
/**
 * The Table Class
 * stores information regarding a table
 *
 * @author Ma Guangheng
 * @version 1.0
 * @since 2021-11-02
 */
public class Table {
	/**
	 * The capacity of the table.
	 */
	private int capacity;
	/**
	 * The number assigned to the table.
	 */
	private int id;
	/**
	 * The present status of the table.
	 */
	private TStatus status;
	/**
	 * The maximum capcity of the table.
	 */
	public static int MAX_CAPACITY = 10;
	/**
	 * The status of the table, whether it is empty, reserved or occupied.
	 */
	public enum TStatus {
		EMPTY, RESERVED, OCCUPIED
	};
	/**
	 * Constructor to create table instances
	 * 
	 * @param tableNo Number assigned to the table.
	 * @param cap Capacity of the table.
	 */
	public Table(int tableNo, int cap) {
		this.id = tableNo;
		this.status = TStatus.EMPTY;
		if (cap > 10)
			capacity = 10;
		else
			capacity = cap;
	}
	/**
	 * Mutator to set table status to empty.
	 */
	public void setEmpty() {
		this.status = TStatus.EMPTY;
	}
	/**
	 * Mutator for set table status to reserved.
	 */
	public void setReserved() {
		this.status = TStatus.RESERVED;
	}
	/**
	 * Mutator to set table status to occupied.
	 */
	public void setOccupied() {
		this.status = TStatus.OCCUPIED;
	}
	/**
	 * Accessor for the status of the table.
	 * @return Status of the table
	 */
	public TStatus getStatus() {
		return status;
	}
	/**
	 * Accessor for the id of the table.
	 * @return id of the table
	 */
	public int getId() {
		return id;
	}
	/**
	 * Accessor for the capacity of the table.
	 * @return Capacity of the table.
	 */
	public int getCapacity() {
		return capacity;
	}
}
