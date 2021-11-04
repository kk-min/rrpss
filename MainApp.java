import java.util.ArrayList;
import java.util.List;

public class MainApp {
	
	public static ArrayList<Table> tableCollection;
	
	public static ArrayList<Reservation> reservationCollection;
	
	private static int tableTrack[] = {2,2,2,2,2};
	
	public static ArrayList<Staff> staffCollection;
	
	public static ArrayList<Order> orderCollection;
	
	public static ArrayList<MenuItem> menuItemCollection;
	
	public static ArrayList<MenuItem[]> menuItemSellRecord;
	
	public MainApp() {
		
	}
	
	private void createTableCollection() {
		int i,j,n = 0,capacity = 2;
		for(i = 0; i < 5; i++) {
			for(j = 0; j < tableTrack[i]; j++) {
				Table table = new Table(n++,capacity);
				tableCollection.add(table);
			}
			capacity += 2;
		}
	}
}

//pull new attributes as you need
