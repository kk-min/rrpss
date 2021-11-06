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
	
	private static void createTableCollection() {
		int i = 0,j,n = 1,capacity = 2;
		while(capacity <= 10) {
			for(j = 0; j < tableTrack[i]; j++) {
				Table table = new Table(n++,capacity);
				tableCollection.add(table);
			}
			i++;
			capacity += 2;
		}
	}
}

//pull new attributes as you need
