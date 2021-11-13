package Classes.Time;

import java.util.Timer;

public class UIExecuteTimer {

	public static void runScheduler() {
		UITimerExample checkExpiredReservationTask = new UITimerExample();

		Timer t = new Timer();
		t.scheduleAtFixedRate(checkExpiredReservationTask, 0, 60 * 1000);
	}
}
