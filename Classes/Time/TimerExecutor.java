package Classes.Time;

import java.util.Timer;

public class TimerExecutor {
	
	public static void runScheduler() {
		TimerSynchroniser sync = new TimerSynchroniser();

		Timer t = new Timer();
		t.scheduleAtFixedRate(sync, 0, 60 * 1000);
	}
}
