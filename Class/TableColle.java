package Project;

import java.util.*;

public class TableColle {
	private ArrayList<Table> colle;
	private int noTrack[];
	public static int tableNo;
	private static int maxTable = 10;

	public TableColle() {
		colle = new ArrayList<Table>();
		tableNo = 1;
		noTrack = new int[5];
		constructColle(colle);
	}

	private void constructColle(ArrayList<Table> colle) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Set tables:");
		int i, no, track = 0;
		for (i = 2; i <= 10; i += 2) {
			System.out.printf("Enter number of %d seats table\n", i);
			no = sc.nextInt();
			if (no > maxTable) {
				System.out.printf("Max %d tables per type.\n", maxTable);
				addTable(maxTable, i);
				noTrack[(i/2)-1] += maxTable;
			} else {
				addTable(no, i);
				noTrack[(i/2)-1] += no;
			}
		}
	}

	private void addTable(int count, int capacity) {
		for (int i = 0; i < count; i++) {
			Table table = new Table(capacity);
			colle.add(table);
		}
	}

	public int assignTable(int customerCount) { // return table ID assigned
		int index = 0, type, i;
		type = (customerCount - 1) / 2;
		for(i = 0; i < type; i++) {
			index += noTrack[i];
		}
		try {
			while (colle.get(index).isOccupied())
				index++;
		} catch (IndexOutOfBoundsException e) {
			System.out.printf("Cannot accommodate %d customers.\n", customerCount);
			return -1;
		}
		colle.get(index).assign();
		return colle.get(index).getID();
	}
	
	public void deassignTable(int id) {
		int n = 0;
		while(colle.get(n).getID() != id) n++;
		colle.get(n).deassign();
	}
}
