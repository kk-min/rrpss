package Project;

import Project.MainApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Table {
	private int capacity;
	public static int MAX_CAPACITY = 10;
	private int ID;
	private boolean occupied;


	public Table(int tableNo, int cap) {
		this.ID = tableNo;
		this.occupied = false;
		if(cap > 10) capacity = 10;
		else capacity = cap;
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
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int cap) {
		if(cap > 10) capacity = 10;
		else capacity = cap;
	}
	
	public static Table getTableByID(int id) {
        for (Table t : MainApp.tableCollection) {
            if (t.getID() == id)
                return t;
        }
        return null;
	}
	
	public static ArrayList<Table> getTheOtherHalf(ArrayList<Table> input){
		ArrayList<Table> output = new ArrayList<Table>(MainApp.tableCollection);
		for(Table t: input)
			output.remove(t);
		output.sort(Comparator.comparingInt(o -> o.capacity));
		return output;
	}
}
