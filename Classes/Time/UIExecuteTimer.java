package Classes.Time;

import java.util.Timer;

public class UIExecuteTimer {

	public static void main(String[] args) {
	}
	
	public static void runScheduler() {
		UITimerExample checkExpiredReservationTask = new UITimerExample("Task");

		Timer t = new Timer();
		t.scheduleAtFixedRate(checkExpiredReservationTask, 0, 60 * 1000);
	}
}
